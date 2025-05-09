package com.ItRoid.turnera.services.Impl;

import com.ItRoid.turnera.entities.ConfiguracionTurnosEntity;
import com.ItRoid.turnera.entities.HorariosEntity;
import com.ItRoid.turnera.models.*;
import com.ItRoid.turnera.repositories.ConfiguracionTurnosRepository;
import com.ItRoid.turnera.repositories.HorariosRepository;
import com.ItRoid.turnera.services.FeriadosService;
import com.ItRoid.turnera.services.HorariosService;
import com.ItRoid.turnera.services.LicenciasService;
import com.ItRoid.turnera.services.ProfesionalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HorariosServiceImpl implements HorariosService {

    Logger logger = LoggerFactory.getLogger(HorariosServiceImpl.class);

    @Autowired
    private HorariosRepository horariosRepository;

    @Autowired
    private ConfiguracionTurnosRepository configuracionTurnosRepository;

    @Autowired
    private FeriadosService feriadosService;

    @Autowired
    private LicenciasService licenciasService;

    @Autowired
    private ProfesionalesService profesionalesService;

    @Override
    public void borrarHorario(Long idHorario) throws Exception {

        HorariosEntity horariosEntity = this.horariosRepository.findByIdHorarios(idHorario);

        if(horariosEntity != null){
            this.horariosRepository.delete(horariosEntity);
        }
    }


    @Override
    public HorariosModel modificarHorario(Long idHorario, HorariosModel horario) throws Exception {

        //formato de hora en 24hs
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        //busco el horario a modificar
        HorariosEntity horariosEntity = this.horariosRepository.findByIdHorarios(idHorario);

        //seteo la variables desde y hasta con fecha y hora actual
        Calendar desde = Calendar.getInstance();
        Calendar hasta = Calendar.getInstance();

        //coloco en desde la hora del primer turno
        desde.set(Calendar.AM_PM, Calendar.AM);
        desde.set(Calendar.HOUR, horario.getHoraDesde());
        desde.set(Calendar.MINUTE, horario.getMinutosDesde());
        desde.set(Calendar.SECOND, 00);
        String horaDesde = format.format(desde.getTime());

        //coloco en desde la hora de fin de ultimo turno
        hasta.set(Calendar.AM_PM, Calendar.AM);
        hasta.set(Calendar.HOUR, horario.getHoraHasta());
        hasta.set(Calendar.MINUTE, horario.getMinutosHasta());
        hasta.set(Calendar.SECOND, 00);
        String horaHasta = format.format(hasta.getTime());

        horariosEntity.setDiaDeSemana(horario.getDiaDeSemana());
        horariosEntity.setTipoTurno(horario.getTipoTurno());
        horariosEntity.setHoraDesde(horaDesde);
        horariosEntity.setHoraHasta(horaHasta);
        horariosEntity.setDuracionTurnos(horario.getDuracionTurnos());

        horariosEntity.setFechaHorarioEventual(horario.getFechaHorarioEventual());

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

        return horario;


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
    public HorariosModel buscarHorariosXId(Long idHorario) throws Exception {

        HorariosEntity horariosEntity = this.horariosRepository.findByIdHorarios(idHorario);

        String[] horadesde = horariosEntity.getHoraDesde().split(":");
        String[] horahasta = horariosEntity.getHoraHasta().split(":");

        HorariosModel horariosModel = new HorariosModel(
                horariosEntity.getIdHorario(),
                horariosEntity.getDiaDeSemana(),
                horariosEntity.getTipoTurno(),
                Integer.parseInt(horadesde[0]),
                Integer.parseInt(horadesde[1]),
                Integer.parseInt(horahasta[0]),
                Integer.parseInt(horahasta[1]),
                horariosEntity.getDuracionTurnos(),
                horariosEntity.getFechaHorarioEventual()
        );

        return horariosModel;

    }

    @Override
    public List<DiasDisponiblesModel> BuscarHorarios(Long idProfesional, String tipoTurno) throws Exception {

        List<HorariosEntity> horariosEntity = this.horariosRepository.findByIdProfesionalYTipoTurno(idProfesional, tipoTurno);

        ProfesionalModel profesionalModel = this.profesionalesService.buscarProfesionalxId(idProfesional);

        List<DiasDisponiblesModel> DiasDisponibles = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Calendar fecha = Calendar.getInstance();

        int añoHoy = Calendar.getInstance().get(Calendar.YEAR);
        int mesHoy = Calendar.getInstance().get(Calendar.MONTH);
        int diaHoy = Calendar.getInstance().get(Calendar.DATE);
        fecha.set(añoHoy, mesHoy, diaHoy);

        int cant = 0;
        int diasApertura = 0;

        // validamos si tiene cargado los dias de apertura, sino lo tiene dejamos por defecto 30 dias
         if (profesionalModel.getDiasAbrirAgenda() == null || Integer.parseInt(profesionalModel.getDiasAbrirAgenda()) == 0){
             diasApertura = 30;
         }else{
             diasApertura = Integer.parseInt(profesionalModel.getDiasAbrirAgenda());
         }

        // cantidad de dias en los que se abre la agenda de turnos
        while(cant < diasApertura){

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

            boolean controlTurnoEventual = false;

            for(int i = 0; horariosEntity.size() > i; i++){

                if (diaDeSemana.equals(horariosEntity.get(i).getDiaDeSemana())){

                    String fechaDisponible = format.format(fecha.getTime());

                    String  fechaEven = horariosEntity.get(i).getFechaHorarioEventual();

                    if(fechaEven==null || fechaEven.equals("")){

                        if (!feriadosService.buscarFeriado(fechaDisponible) && !licenciasService.buscarDiaEnLicencias(idProfesional, fechaDisponible)) {

                            DiasDisponiblesModel diasDisponibles = new DiasDisponiblesModel(
                                    horariosEntity.get(i).getIdHorario(),
                                    diaDeSemana,
                                    fechaDisponible
                            );

                            DiasDisponibles.add(diasDisponibles);
                        }
                    }else{

                        if(esEventual(idProfesional, fechaDisponible, horariosEntity.get(i).getTipoTurno()) && !controlTurnoEventual){

                            HorariosEntity hEventual = this.horariosRepository.esHoararioEventual(idProfesional, fechaDisponible, horariosEntity.get(i).getTipoTurno());

                            DiasDisponiblesModel diasDisponibles = new DiasDisponiblesModel(
                                    hEventual.getIdHorario(),
                                    diaDeSemana,
                                    fechaDisponible
                            );
                            controlTurnoEventual = true;
                            DiasDisponibles.add(diasDisponibles);
                        }
                    }
                }

            }
            fecha.add(Calendar.DATE, 1);
            cant++;
        }

        return DiasDisponibles;
    }

    @Override
    public boolean esEventual(Long idProfesional, String fecha, String tipoTurno){
        boolean esEventual = false;

        HorariosEntity h = this.horariosRepository.esHoararioEventual(idProfesional, fecha, tipoTurno);

        if (h!=null){
            esEventual = true;
        }

        return esEventual;
    }

    @Override
    public List<DiasAtencionModel> BuscarHorarios(Long idProfesional) throws Exception {

        List<HorariosEntity> horariosEntity = this.horariosRepository.findByIdProfesional(idProfesional);

        if (horariosEntity != null) {

            List<DiasAtencionModel> list = horariosEntity
                    .stream()
                    .map((e) -> new DiasAtencionModel(
                            e.getIdHorario(),
                            e.getFechaAlta(),
                            e.getDiaDeSemana(),
                            e.getTipoTurno(),
                            e.getHoraDesde(),
                            e.getHoraHasta(),
                            e.getDuracionTurnos(),
                            e.getFechaHorarioEventual()))
                    .collect(Collectors.toList());

            return list;

        }else{
            throw new Exception("No existe horarios cargados para el profesional: " +  idProfesional);
        }


    }

    @Override
    public List<String> BuscarHorariosParaTarjeta(Long idProfesional) throws Exception {

        List<String> dias = this.horariosRepository.diasAtencion(idProfesional);

       if(dias!=null){

            return dias;

        }else{
            throw new Exception("No existe horarios cargados para el profesional: " +  idProfesional);
        }


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
