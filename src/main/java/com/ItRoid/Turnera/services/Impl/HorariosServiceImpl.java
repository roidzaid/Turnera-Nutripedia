package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.ConfiguracionTurnosEntity;
import com.ItRoid.Turnera.entities.HorariosEntity;
import com.ItRoid.Turnera.models.ConfiguracionTurnoModel;
import com.ItRoid.Turnera.models.DiasDisponiblesModel;
import com.ItRoid.Turnera.models.HorariosModel;
import com.ItRoid.Turnera.repositories.ConfiguracionTurnosRepository;
import com.ItRoid.Turnera.repositories.HorariosRepository;
import com.ItRoid.Turnera.services.FeriadosService;
import com.ItRoid.Turnera.services.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class HorariosServiceImpl implements HorariosService {


    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private ConfiguracionTurnosRepository configuracionTurnosRepository;

    @Autowired
    private FeriadosService feriadosService;


    @Override
    public void borrarHorario(Long idHorario) throws Exception {

        HorariosEntity horariosEntity = this.horariosRepository.findByIdHorarios(idHorario);

        if(horariosEntity != null){
            this.horariosRepository.delete(horariosEntity);
        }
    }


    @Override
    public void modificarHorario(Long idHorario, HorariosModel horario) throws Exception {

        HorariosEntity horariosEntity = this.horariosRepository.findByIdHorarios(idHorario);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.HOUR, horario.getHoraDesde());
        calendar.set(Calendar.MINUTE, horario.getMinutosDesde());
        calendar.set(Calendar.SECOND, 00);

        SimpleDateFormat format = new SimpleDateFormat("hh:mm");

        String horaDesde = format.format(calendar.getTime());

        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.HOUR, horario.getHoraHasta());
        calendar.set(Calendar.MINUTE, horario.getMinutosHasta());
        calendar.set(Calendar.SECOND, 00);
        String horaHasta = format.format(calendar.getTime());

        horariosEntity.setDiaDeSemana(horario.getDiaDeSemana());
        horariosEntity.setTipoTurno(horario.getTipoTurno());
        horariosEntity.setHoraDesde(horaDesde);
        horariosEntity.setHoraHasta(horaHasta);
        horariosEntity.setDuracionTurnos(horario.getDuracionTurnos());

        //configuracion de turnos
        int horaSig = horario.getHoraDesde();
        int minSig = horario.getMinutosDesde();

        Calendar ultTurno = Calendar.getInstance();

        int añoHoy = Calendar.getInstance().get(Calendar.YEAR);
        int mesHoy = Calendar.getInstance().get(Calendar.MONTH);
        int diaHoy = Calendar.getInstance().get(Calendar.DATE);
        ultTurno.set(añoHoy, mesHoy, diaHoy);

        ultTurno.set(Calendar.AM_PM, Calendar.AM);
        ultTurno.set(Calendar.HOUR, horario.getHoraHasta());
        ultTurno.set(Calendar.MINUTE, horario.getMinutosHasta());

        ultTurno.add(Calendar.MINUTE, -horario.getDuracionTurnos());

        List<ConfiguracionTurnosEntity> listaConfigTurnos = new ArrayList<>();
        boolean ultimo = false;

        Calendar turno = Calendar.getInstance();

        turno.set(añoHoy, mesHoy, diaHoy);

        turno.set(Calendar.AM_PM, Calendar.AM);
        turno.set(Calendar.HOUR, horaSig);
        turno.set(Calendar.MINUTE, minSig);
        turno.set(Calendar.SECOND, 00);

        while (!ultimo) {

            ConfiguracionTurnosEntity configuracionTurnosEntity = new ConfiguracionTurnosEntity();

            String hora = format.format(turno.getTime());

            configuracionTurnosEntity.setHora(hora);

            listaConfigTurnos.add(configuracionTurnosEntity);

            turno.add(Calendar.MINUTE, horario.getDuracionTurnos());

            if (turno.getTime().compareTo(ultTurno.getTime()) > 0) {
                ultimo = true;
            }
        }


        List<Long> listaBorrar = new ArrayList<>();
        for(int i = 0; horariosEntity.getConfiguracionTurnos().size() > i; i++){
            listaBorrar.add(horariosEntity.getConfiguracionTurnos().get(i).getIdConfiguracionTurnos());
        }

        horariosEntity.getConfiguracionTurnos().clear();

        horariosEntity.setConfiguracionTurnos(listaConfigTurnos);

        this.horariosRepository.save(horariosEntity);

        //borra la configuracion anterior
        borrarConfiguacionTurnos(listaBorrar);


    }

    @Override
    public List<String> buscarConfiguracionTurnos(Long idHorario) throws Exception {

        List<ConfiguracionTurnosEntity> configuracionTurnosEntity = this.configuracionTurnosRepository.findByConfiguracionTurnos(idHorario);

        if (configuracionTurnosEntity != null) {

            List<String> configuracionturnos = new ArrayList<>();

            for(int i = 0; configuracionTurnosEntity.size() > i; i++){
                configuracionturnos.add(configuracionTurnosEntity.get(i).getHora());
            }

            return configuracionturnos;

        }else{
            throw new Exception("El profesional no tiene horarios cargados");
        }


    }

    @Override
    public List<DiasDisponiblesModel> BuscarHorarios(Long idProfesional, String tipoTurno) throws Exception {

        List<HorariosEntity> horariosEntity = this.horariosRepository.findByIdProfesionalYTipoTurno(idProfesional, tipoTurno);

        List<DiasDisponiblesModel> DiasDisponibles = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Calendar fecha = Calendar.getInstance();

        int añoHoy = Calendar.getInstance().get(Calendar.YEAR);
        int mesHoy = Calendar.getInstance().get(Calendar.MONTH);
        int diaHoy = Calendar.getInstance().get(Calendar.DATE);
        fecha.set(añoHoy, mesHoy, diaHoy);

        int cant = 0;

        // cantidad de dias en los que se abre la agenda de turnos
        while(cant < 30){

            String diaDeSemana="";
            int nD =-1;

            nD=fecha.get(Calendar.DAY_OF_WEEK);
            switch (nD){
                case 1: diaDeSemana = "DOMINGO";
                    break;
                case 2: diaDeSemana = "LUNES";
                    break;
                case 3: diaDeSemana = "MARTES";
                    break;
                case 4: diaDeSemana = "MIERCOLES";
                    break;
                case 5: diaDeSemana = "JUEVES";
                    break;
                case 6: diaDeSemana = "VIERNES";
                    break;
                case 7: diaDeSemana = "SABADO";
                    break;
            }

            for(int i = 0; horariosEntity.size() > i; i++){

                if (diaDeSemana.equals(horariosEntity.get(i).getDiaDeSemana())){

                    String fechaDisponible = format.format(fecha.getTime());

                    if (!feriadosService.buscarFeriado(fechaDisponible)) {

                        DiasDisponiblesModel diasDisponibles = new DiasDisponiblesModel(
                                horariosEntity.get(i).getIdHorario(),
                                diaDeSemana,
                                fechaDisponible
                        );

                        DiasDisponibles.add(diasDisponibles);
                    }
                }

            }
            fecha.add(Calendar.DATE, 1);
            cant++;
        }

        return DiasDisponibles;
    }

    @Override
    public List<String> buscarTiposDeTurno(Long idProfesional) throws Exception {

        List<String> tiposDeTurnos = this.horariosRepository.findTipoTurnos(idProfesional);

        return tiposDeTurnos;

    }

    @Override
    public ConfiguracionTurnoModel buscarConfiguracionDeTurno(Long idConfiguracionTurno) throws Exception {

        ConfiguracionTurnosEntity configuracionTurnosEntity = this.configuracionTurnosRepository.findByIdConfiguracionTurno(idConfiguracionTurno);

        ConfiguracionTurnoModel configuracionTurnoModel = new ConfiguracionTurnoModel(
                configuracionTurnosEntity.getIdConfiguracionTurnos(),
                configuracionTurnosEntity.getHora()
        );

        return configuracionTurnoModel;
    }


    //////////Borra la configuracion anterior de los turnos
    public void borrarConfiguacionTurnos (List<Long> idConfiguracionTurnos){

        for(int i = 0; idConfiguracionTurnos.size() > i; i++){

            ConfiguracionTurnosEntity ConfiguracionTurnosEntity = this.configuracionTurnosRepository.findByIdConfiguracionTurno(idConfiguracionTurnos.get(i));
            this.configuracionTurnosRepository.delete(ConfiguracionTurnosEntity);

        }
    }

}
