package com.facultad;

import com.dao.CarreraDAO;
import com.dao.CiudadDAO;
import com.dao.FacultadDAO;
import com.dao.MateriaDAO;
import com.dao.ProfesorDAO;
import com.facultad.Util.HibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws ParseException {
        SessionFactory  sf = HibernateUtil.getSessionFactory();     
        
        //Punto 1 y 2
        InitialCreate(sf);
        
        //Punto 3
        AlumnosOrdenadosPorApellido(sf);
        ProfesoresOrdenadosPorAntiguedad(sf);
        MateriasPorNivel(sf, "Avanzado");        
        
        //Punto 4
        CiudadService();
        ProfesorService();
        MateriaService();        
        CarreraService();
        FacultadService();
        
        HibernateUtil.close();
    }

    public static void InitialCreate(SessionFactory sf) throws ParseException{        
        Ciudad ciudadBsAs = new Ciudad();
        ciudadBsAs.setNombre("Buenos Aires");
        Ciudad ciudadSFE = new Ciudad();
        ciudadSFE.setNombre("Santa Fe");
        Ciudad ciudadCBA = new Ciudad();
        ciudadCBA.setNombre("Cordoba");
        
        DateFormat formateador= new SimpleDateFormat("dd/M/yyyy");
        Profesor profGimenez = new Profesor("Gimenez","Juan", 10000222, formateador.parse("01/01/1970"), ciudadBsAs, 15);
        Profesor profLuna = new Profesor("Luna","Ariel", 10000222, formateador.parse("10/11/1984"), ciudadBsAs, 2);
        Profesor profLopez = new Profesor("Lopez","Silvio", 15111444, formateador.parse("10/01/1969"), ciudadSFE, 30);
        Profesor profMartinez = new Profesor("Martinez","Marcos", 28987111,formateador.parse("25/04/1980"), ciudadCBA, 5);
            
        Alumno alGomez = new Alumno("Gomez", "Matias", 40111222, formateador.parse("01/12/2000"), ciudadBsAs, "101", 2020);
        Alumno alPerez = new Alumno("Perez", "Sabrina", 41999222, formateador.parse("21/12/2003"), ciudadBsAs, "102", 2020);
         
        Materia matematicaBasica = new Materia();
        matematicaBasica.setNombre("Matematica Basica");
        matematicaBasica.setNivel("Principiante");
        matematicaBasica.setProfesor(profGimenez);
        
        Materia quimica1 = new Materia();
        quimica1.setNombre("Quimica Basica");
        quimica1.setNivel("Principiante");
        quimica1.setProfesor(profLuna);
     
        Materia contBasica = new Materia();
        contBasica.setNombre("Contabilidad Basica");
        contBasica.setNivel("Principiante");
        contBasica.setProfesor(profGimenez);
              
        Materia programacion1 = new Materia();
        programacion1.setNombre("Programacion Basica");
        programacion1.setNivel("Principiante");
        programacion1.setProfesor(profLuna);
       
        Materia programacion2 = new Materia();
        programacion2.setNombre("Programacion Avanzada");
        programacion2.setNivel("Avanzado");
        programacion2.setProfesor(profLuna);        
       
        //N:M
        Set<Materia> materias = new HashSet<>();
        materias.add(matematicaBasica);
        
        Set<Alumno> alumnos = new HashSet<>();
        alumnos.add(alGomez);
        alumnos.add(alPerez);
        
        matematicaBasica.setAlumnos(alumnos);        
          
        Facultad facultadStaFe = new Facultad();
        facultadStaFe.setNombre("Facultad Regional Santa Fe");
        facultadStaFe.setCiudad(ciudadSFE);  
        
        Facultad facultadBsAs = new Facultad();
        facultadBsAs.setNombre("Facultad Regional Buenos Aires");
        facultadBsAs.setCiudad(ciudadBsAs);
        
        Facultad facultadCba = new Facultad();
        facultadCba.setNombre("Facultad Regional Cordoba");
        facultadCba.setCiudad(ciudadCBA);
        
        Carrera carreraTUTI = new Carrera();
        carreraTUTI.setNombre("Tec univ. en Tecnologia de Informacion");
        carreraTUTI.getMaterias().add(programacion1);
        carreraTUTI.getMaterias().add(programacion2);
        carreraTUTI.getMaterias().add(matematicaBasica);
        carreraTUTI.setFacultad(facultadStaFe);
        
        Carrera carreraTSTL = new Carrera();
        carreraTSTL.setNombre("Tec Sup en Transporte y Logistica");
        carreraTSTL.getMaterias().add(matematicaBasica);
        carreraTSTL.getMaterias().add(contBasica);
        carreraTUTI.setFacultad(facultadBsAs);
                
        Session session = sf.openSession();
        Transaction trx = session.beginTransaction();
          
            session.save(ciudadBsAs);
            session.save(ciudadSFE);
            session.save(ciudadCBA);

            session.save(profGimenez);
            session.save(profLuna);
            session.save(profLopez);
            session.save(profMartinez);

            session.save(matematicaBasica);

            session.save(carreraTUTI);
            session.save(carreraTSTL);     

            session.save(facultadStaFe);
            session.save(facultadBsAs);
            session.save(facultadCba);

        trx.commit();
        
        session.close();        
    }
    
    private static void AlumnosOrdenadosPorApellido(SessionFactory sf) {
        Session session = sf.openSession();
        List<Alumno> alumnos = session.createQuery("From Alumno order by Apellido asc").list();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());            
        }
        
        session.close();
    }
    
    private static void ProfesoresOrdenadosPorAntiguedad(SessionFactory sf) {
        Session session = sf.openSession();
        List<Profesor> profesores = session.createQuery("From Profesor order by Antiguedad desc").list();
        for (Profesor profesor : profesores) {
            System.out.println(profesor.toString());            
        }
        
        session.close();
    }
    
    private static void MateriasPorNivel(SessionFactory sf, String nivel ) {
        Session session = sf.openSession();
        Query query = session.createQuery("From Materia where nivel= :nivel");
        query.setParameter("nivel", nivel);
        List<Materia> materias = query.list();
        
        for (Materia materia : materias) {
            System.out.println(materia.toString());            
        }
        
        session.close();
    }
    
    public static void CiudadService(){ 
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("NQN");
        CiudadDAO<Ciudad> ciudadDAO = new CiudadDAO<>();
        ciudadDAO.create(ciudad);     
        
        Ciudad ciudadRecover = ciudadDAO.read(ciudad.getId(), Ciudad.class);
        System.out.println(ciudadRecover.toString());
      
        ciudadRecover.setNombre("Neuquen");
        ciudadDAO.update(ciudadRecover);
      
        ciudadDAO.delete(ciudadRecover);
    }
    
    public static void ProfesorService() throws ParseException{ 
        CiudadDAO<Ciudad> ciudadDAO = new CiudadDAO<>();        
        ProfesorDAO<Profesor> profesorDAO = new ProfesorDAO<>();
        
        Ciudad ciudadRecover = ciudadDAO.read(Long.valueOf(3), Ciudad.class);  
        
        DateFormat formateador= new SimpleDateFormat("dd/M/yyyy");
        Profesor profesor = new Profesor("Hilton","Peter", 7909101, formateador.parse("01/01/1951"), ciudadRecover, 3);
        
        profesorDAO.create(profesor);
        
        Profesor profesorRecover = profesorDAO.read(profesor.getId(), Profesor.class);
        System.out.println(profesorRecover.toString());
      
        profesorRecover.setNombre("Peter John");
        profesorDAO.update(profesorRecover);
      
        profesorDAO.delete(profesorRecover);
    }
    
    public static void MateriaService() throws ParseException{ 
        ProfesorDAO<Profesor> profesorDAO = new ProfesorDAO<>();
        MateriaDAO<Materia> materiaDAO = new MateriaDAO<>();
        
        Materia materia = new Materia();
        materia.setNombre("Fisica");
        materia.setNivel("Avanzado");
        Profesor profesorRecover = profesorDAO.read(Long.valueOf(3), Profesor.class);        
        materia.setProfesor(profesorRecover);        
        
        Set<Materia> materias = new HashSet<>();
        materias.add(materia);
        
        materiaDAO.create(materia);
       
        Materia materiaRecover = materiaDAO.read(materia.getId(), Materia.class);
        System.out.println(materiaRecover.toString());
      
        materiaRecover.setNombre("Fisica II");
        materiaDAO.update(materiaRecover);
      
        materiaDAO.delete(materiaRecover);
    }    
    
    public static void CarreraService() throws ParseException{
        CarreraDAO<Carrera> carreraDAO = new CarreraDAO<>();  
        MateriaDAO<Materia> materiaDAO = new MateriaDAO<>();
        FacultadDAO<Facultad> facultadDAO = new FacultadDAO<>();
        ProfesorDAO<Profesor> profesorDAO = new ProfesorDAO<>();

        Materia materiaRecover =(Materia) materiaDAO.read(Long.valueOf(6), Materia.class);
        
        Facultad facultadRecover =(Facultad)facultadDAO.read(Long.valueOf(3), Facultad.class);
        
        Carrera carreraNew = new Carrera();
        carreraNew.setNombre("Tec univ. Seg e Hig");
        carreraNew.getMaterias().add(materiaRecover);
        carreraNew.setFacultad(facultadRecover);
        
        carreraDAO.create(carreraNew);
        
        Carrera carreraRecover = (Carrera) carreraDAO.read(carreraNew.getId(), Carrera.class);
        System.out.println(carreraRecover.toString());
      
        carreraRecover.setNombre("Tec. universitario en Seguridad e Higiene");
        carreraDAO.update(carreraRecover);
      
        carreraDAO.delete(carreraRecover);  
    }
        
    public static void FacultadService(){   
        CiudadDAO<Ciudad> ciudadDAO = new CiudadDAO<>();
        FacultadDAO<Facultad> facultadDAO = new FacultadDAO<>();
           
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre("Entre Rios");
        ciudadDAO.create(ciudad);     
        
        Facultad facultad = new Facultad();
        facultad.setNombre("Facultad Regional ER");
        facultad.setCiudad(ciudad);        
        facultadDAO.create(facultad);     
        
        Facultad facultadRecover = facultadDAO.read(facultad.getId(), Facultad.class);
        System.out.println(facultadRecover.toString());
      
        facultadRecover.setNombre("Facultad Regional Entre Rios");
        facultadDAO.update(facultadRecover);
      
        facultadDAO.delete(facultadRecover);
    }
}
