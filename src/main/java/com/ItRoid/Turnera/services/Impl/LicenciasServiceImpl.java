package com.ItRoid.Turnera.services.Impl;

import com.ItRoid.Turnera.entities.LicenciasEntity;
import com.ItRoid.Turnera.models.LicenciasModel;
import com.ItRoid.Turnera.models.ProfesionalModel;
import com.ItRoid.Turnera.repositories.LicenciasRepository;
import com.ItRoid.Turnera.services.LicenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LicenciasServiceImpl implements LicenciasService {


    @Autowired
    private LicenciasRepository licenciasRepository;

    @Override
    public LicenciasModel altaLicencia(LicenciasModel licenciasModel) {

        //validar si la licencias ya fue dada de alta


        //cargar un registro por dia licencia
        //SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        String[] fechaFormato = licenciasModel.getDiaDesde().split("-");
        String desde = fechaFormato[2] + "-" + fechaFormato[1] + "-" + fechaFormato[0];

        fechaFormato = licenciasModel.getDiaHasta().split("-");
        String hasta = fechaFormato[2] + "-" + fechaFormato[1] + "-" + fechaFormato[0];

        try {

            Date fechaDesde = formato.parse(licenciasModel.getDiaDesde());
            Date fechaHasta = formato.parse(licenciasModel.getDiaHasta());

            Calendar calendarDesde = Calendar.getInstance();
            calendarDesde.setTime(fechaDesde);

            Calendar calendarHasta = Calendar.getInstance();
            calendarHasta.setTime(fechaHasta);

            while (calendarDesde.before(calendarHasta) || calendarDesde.equals(calendarHasta)) {

                String fechaAux = formato.format(calendarDesde.getTime());
                fechaFormato = fechaAux.split("-");
                String fecha = fechaFormato[2] + "-" + fechaFormato[1] + "-" + fechaFormato[0];


                LicenciasEntity licenciasEntity = new LicenciasEntity(
                        licenciasModel.getIdProfesional(),
                        fecha,
                        desde,
                        hasta,
                        licenciasModel.getMotivoDeLicencia(),
                        calendarDesde.getTime(),
                        fechaDesde,
                        fechaHasta
                        );

                this.licenciasRepository.save(licenciasEntity);

                calendarDesde.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException ex) {
            System.out.println(ex);
        }

        return licenciasModel;
    }

    @Override
    public List<LicenciasModel> buscarLicencias(Long idProfesional) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendarHoy = Calendar.getInstance();

        Date fechaDesde = calendarHoy.getTime();

        List<LicenciasEntity> lista = this.licenciasRepository.findByIdProfesional(idProfesional, fechaDesde);

        if(lista != null) {

            List<LicenciasModel> licencias = new ArrayList<>();

            int i = 0;
            while(lista.size()>i){

                String desdeAnt = lista.get(i).getDiaDesde();
                String hastaAnt = lista.get(i).getDiaHasta();

                LicenciasModel licencia = new LicenciasModel(
                        lista.get(i).getIdLicencia(),
                        lista.get(i).getIdProfesional(),
                        lista.get(i).getDiaDesde(),
                        lista.get(i).getDiaHasta(),
                        lista.get(i).getMotivoDeLicencia()
                        );

                licencias.add(licencia);

                while(lista.size()>i && desdeAnt.equals(lista.get(i).getDiaDesde()) && hastaAnt.equals(lista.get(i).getDiaHasta())) {
                    i++;
                }

            }

            return licencias;

        }else{
            return null;
        }
    }

    @Override
    public boolean buscarDiaEnLicencias(Long idProfesional, String dia) {

        String licencia = this.licenciasRepository.findByIdProfesionalYDia(idProfesional, dia);

        boolean esLicencia = false;

        if (licencia != null) {
            esLicencia = true;
        }

        return esLicencia;
    }

    @Override
    public LicenciasModel buscarLicencia(Long idProfesional, Long idLicencia) throws ParseException {

        LicenciasEntity licenciasEntity = this.licenciasRepository.findByidProfesionalYIdLicencia(idProfesional, idLicencia);

        LicenciasModel licenciasModel = new LicenciasModel();

        if(licenciasEntity!=null){

              licenciasModel.setIdLicencia(licenciasEntity.getIdLicencia());
              licenciasModel.setIdProfesional(licenciasEntity.getIdProfesional());
              licenciasModel.setDiaDesde(licenciasEntity.getDiaDesde());
              licenciasModel.setDiaHasta(licenciasEntity.getDiaHasta());
              licenciasModel.setMotivoDeLicencia(licenciasEntity.getMotivoDeLicencia());

        }

        return licenciasModel;

    }


    //////////


    @Override
    public LicenciasModel modifLicencia(Long idProfesional, Long idLicencia, LicenciasModel licenciasModel) throws ParseException {

        if(licenciaValida(licenciasModel.getDiaDesde(), licenciasModel.getDiaHasta())) {

            LicenciasModel licenciaAModificar = buscarLicencia(idProfesional, idLicencia);

            List<LicenciasEntity> lista = this.licenciasRepository.findByFechas(idProfesional, licenciaAModificar.getDiaDesde(), licenciaAModificar.getDiaHasta());

            if (lista.size() > 0) {

                for (int i = 0; lista.size() > i; i++) {
                    this.licenciasRepository.delete(lista.get(i));
                }

                altaLicencia(licenciasModel);

            }
        }

        return licenciasModel;

    }

    private boolean licenciaValida(String fechaDesde, String fechaHasta){

        boolean esValida = true;

        //SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date desde = formato.parse(fechaDesde);
            Date hasta = formato.parse(fechaHasta);

            Calendar calendarDesde = Calendar.getInstance();
            calendarDesde.setTime(desde);

            Calendar calendarHasta = Calendar.getInstance();
            calendarHasta.setTime(hasta);

            Calendar hoy = Calendar.getInstance();

            if(desde.before(hoy.getTime()) || desde.after(hasta)){

                esValida = false;

            }

        }catch (ParseException ex) {
            System.out.println(ex);
        }

        return esValida;

    }



    @Override
    public void deleteLicencia(Long idProfesional, Long idLicencia) throws ParseException {

        LicenciasModel licenciaABorrar = buscarLicencia(idProfesional, idLicencia);

        List<LicenciasEntity> lista = this.licenciasRepository.findByFechas(idProfesional, licenciaABorrar.getDiaDesde(), licenciaABorrar.getDiaHasta());

        if (lista != null) {

            for (int i=0; lista.size()>i; i++){
                this.licenciasRepository.delete(lista.get(i));
            }

        }
    }
}
