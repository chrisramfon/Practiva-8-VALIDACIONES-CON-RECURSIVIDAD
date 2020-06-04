/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearreglos;

import java.util.Scanner;

/**
 *
 * @author ali
 */
public class ArreglosMulti {
    
    validaciones leert = new validaciones();
    private int c;
    int f;
    private int LimiteF;
    int LimiteC;
    persona[][] APersonas;
    Scanner leer = new Scanner(System.in);
    
    public ArreglosMulti(int filas, int columnas) {
        APersonas = new persona[filas][columnas];
        f = 0;
        c = 0;
        LimiteF = filas;
        LimiteC = columnas;
        inicializar();
    }
    
    public void menu() {
        int opc = 0;
        do {
            System.out.println("Menu Principal");
            System.out.println("1.-Agregar");
            System.out.println("2.-Mostrar");
            System.out.println("3.-MostrarTodo");
            System.out.println("4.-Buscar");
            System.out.println("5.-Buscar posicion");
            System.out.println("6.-Eliminar");
            System.out.println("7.-Modificar Campos");
            System.out.println("8.-Salir");
            opc = leer.nextInt();
            String vnombre = " qwertyuiopasdfghjklñzxcvbnm,.QWERTYUIOPASDFGHJKLÑZXCVBNMáéíóúÁÉÍÓÚü";//Nombre
            String teleciclo = " 1234567890-()";//Número de telefono
            String casa = " qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM1230456789#.,-";//Direccion
            String ab = "qwertyuiopasdfghjklñzxcvbnm.QWERTYUIOPASDFGHJKLÑZXCVBNM_-@0123456789";//Correo
            switch (opc) {
                case 1:
                    persona px = new persona();
                    System.out.println("Agregar Persona-->");
                    System.out.println("Ingresa código");
                    int codi = leert.leerEntero();
                    px.setCod(codi);
                    System.out.println("Ingresa Nombre-->");
                    String nom = leert.leerNombre(vnombre);
                    px.setNombre(nom);
                    System.out.println("Agregar Apellidos-->");
                    String ap = leert.leerNombre(vnombre);
                    px.setApellido(ap);
                    System.out.println("Ingresa Edad-->");
                    int edad = leert.leerEntero();
                    px.setEdad(edad);
                    System.out.println("Ingresa telefono-->");
                    String tele = leert.leerNombre(teleciclo);
                    px.setTelefono(tele);
                    System.out.println("Ingresa dirección-->");
                    String direct = leert.leerNombre(casa);
                    px.setDireccion(direct);
                    System.out.println("Ingresa correo");
                    String email = leert.leerNombre(ab);
                    px.setcorreo(email);
                    Agregar(px);
                    break;
                case 2:
                    this.Mostrar();
                    break;
                case 3:
                    this.MostrarTodo();
                    break;
                case 4:
                    System.out.println("Buscar Persona");
                    System.out.println("Escribe el nombre de la persona");
                    String bnom = leert.leerNombre(vnombre);
                    persona p = this.Buscar(bnom);
                    if (p != null) {
                        System.out.println("Persona Encontrada");
                        p.mostrar();
                    } else {
                        System.out.println("persona no encontrada");
                    }
                    
                    ;
                    break;
                case 5:
                    String nombre1;
                    System.out.println("Buscar Persona");
                    System.out.println("Escribe el nombre de la persona");
                    nombre1 = leert.leerNombre(vnombre);
                    cordenadas cor = this.BuscarPos(nombre1);
                    if (cor != null) {
                        System.out.println("Persona Encontrada en las coordenadas ->");
                        System.out.println(" fila --> " + cor.fila + "columna --> " + cor.columna);
                        APersonas[cor.fila][cor.columna].mostrar();

                        //p.mostrar();
                    } else {
                        System.out.println("persona no encontrada");
                    }
                    
                    ;
                    break;
                case 6:
                    int eopc;
                    System.out.println("Ingresa el nombre de la persona a eliminar\n.\n.\n.\n.");
                    String mon = leert.leerNombre(vnombre);
                    do {
                        System.out.println("¿Quieres eliminar a la persona?\n.\n.\n.\n.\n1. Si\n2. No");
                        eopc = leert.leerEntero();
                        switch (eopc) {
                            case 1:
                                boolean resu = Eliminar(mon);
                                if (resu == false) {
                                    System.out.println("La persona no existe");
                                } else {
                                    System.out.println("Persona eliminada");
                                }
                                eopc = 2;
                                break;
                            
                            case 2:
                                System.out.println("Saliendo de eliminar persona");
                                break;
                            default:
                                System.out.println("Elige una opción valida");
                                break;
                        }
                    } while (eopc != 2);
                    
                    break;
                case 7:
                    System.out.println("Ingresa el nombre de la persona a modificar");
                    String g = leert.leerNombre(vnombre);
                    boolean res = this.ModificarCampos(g);
                    if (res != false) {
                        System.out.println("Dato modificado con éxito");
                    }
                default:
                    System.out.println("Elige una opcion valida");
            }
        } while (opc < 8);
    }
    
    public void Agregar(persona P) {
        if (f < LimiteF) {
            if (c < LimiteC) {
                this.APersonas[f][c++] = P;
            } else {
                
                c = 0;
                if (f < (LimiteF - 1)) {
                    this.APersonas[++f][c++] = P;
                } else {
                    System.out.println("Matriz llena");
                }
            }
            
        } else {
            System.out.println("Matriz llena");
        }
        
    }
    
    public void MostrarTodo() {
        for (int y = 0; y < LimiteF; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null) {
                    System.out.println("posicion Fila " + y + " col " + x + ":" + APersonas[y][x].getNombre());
                }
            }
        }
    }
    
    public void Mostrar() {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null) {
                    if (APersonas[y][x].getNombre() != null) {
                        System.out.println("Código: " + APersonas[y][x].getCod() + "\n");
                        System.out.println("Nombre: " + APersonas[y][x].getNombre() + "\n");
                        System.out.println("Apellidos: " + APersonas[y][x].getApellido() + "\n");
                        System.out.println("Edad: " + APersonas[y][x].getEdad() + " años" + "\n");
                        System.out.println("Télefono: " + APersonas[y][x].getTelefono() + "\n");
                        System.out.println("Dirección: " + APersonas[y][x].getDireccion() + "\n");
                        System.out.println("Correo: " + APersonas[y][x].getCorreo() + "\n" + "----------------------------------------------------------------");
                    }
                }
            }
        }
    }
    
    public persona Buscar(String nom) {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null && APersonas[y][x].getNombre() != null) {
                    if (APersonas[y][x].getNombre().equals(nom)) {
                        //System.out.println("posicion Fila "+y+" col "+x+":"+APersonas[y][x].getNombre());
                        return APersonas[y][x];
                    }
                }
                
            }
        }
        
        return null;
    }
    
    public cordenadas BuscarPos(String nom) {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null && APersonas[y][x].getNombre() != null) {
                    if (APersonas[y][x].getNombre().equals(nom)) {
                        //System.out.println("posicion Fila "+y+" col "+x+":"+APersonas[y][x].getNombre());

                        return new cordenadas(x, y);
                    }
                }
                
            }
        }
        
        return null;
    }
    
    public boolean ModificarCampos(String nombre) {
        String vnombre = " qwertyuiopasdfghjklñzxcvbnm,.QWERTYUIOPASDFGHJKLÑZXCVBNMáéíóúÁÉÍÓÚü";//nombre
        String teleciclo = " 1234567890-()";// numero de telefono
        String casa = " qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM1230456789#.,-";//Direccion 
        String ab = "qwertyuiopasdfghjklñzxcvbnm.QWERTYUIOPASDFGHJKLÑZXCVBNM_-@0123456789";//Correo email
        if (BuscarPos(nombre) != null) {
            cordenadas search = BuscarPos(nombre);
            int fil = search.getFila();
            int col = search.getColumna();
            persona e = APersonas[fil][col];
            int mopc;
            do {
                System.out.println("¿Qué quieres modificar?\n.\n.\n.\n1. Nombre\n2. Apellido\n3. Edad\n4. Direccion\n5. Telefono\n6. Correo\n7. Confirmar");
                mopc = leert.leerEntero();
                switch (mopc) {
                    case 1:
                        
                        System.out.println("Escribe el nuevo nombre");
                        String nuev = leert.leerNombre(vnombre);
                        e.setNombre(nuev);
                        
                        break;
                    case 2:
                        
                        System.out.println("Escribe el nuevo Apellido");
                        String nuevo = leert.leerNombre(vnombre);
                        e.setApellido(nuevo);
                        break;
                    case 3:
                        System.out.println("Escribe la nueva edad");
                        int nuevoo = leert.leerEntero();
                        e.setEdad(nuevoo);
                        break;
                    case 4:
                        System.out.println("Escribe la nueva dirección");
                        String dire = leert.leerNombre(casa);
                        e.setDireccion(dire);
                        break;
                    
                    case 5:
                        System.out.println("Escribe el nuevo número de telefono");
                        String teli = leert.leerNombre(teleciclo);
                        e.setTelefono(teli);
                        break;
                    case 6:
                        System.out.println("Escribe el nuevo correo");
                        String corre = leert.leerNombre(ab);
                        e.setcorreo(corre);
                        break;
                    case 7:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("La opcion no existe");
                        break;
                }
                
            } while (mopc != 7);
            return true;
        }
        return false;
    }
    
    public boolean Modificar(String nombre) {
        String vnombre = " qwertyuiopasdfghjklñzxcvbnm,.QWERTYUIOPASDFGHJKLÑZXCVBNMáéíóúÁÉÍÓÚü";
        cordenadas cord = this.BuscarPos(nombre);
        if (cord != null) {
            persona p = APersonas[cord.fila][cord.columna];
            p.mostrar();
            
            System.out.println("Ingresa el nuevo nombre (" + p.getNombre() + ")");
            String nom = leert.leerNombre(vnombre);
            // APersonas[cord.fila][cord.columna].setNombre(nom);
            p.setNombre(nom);
            System.out.println("Ingresa el nuevo Apellido (" + p.getApellido() + ")");
            String ap = leert.leerNombre(vnombre);
            // APersonas[cord.fila][cord.columna].setApellido(ap);
            p.setApellido(ap);
            System.out.println("Ingresa el nuevo Edad (" + p.getEdad() + ")");
            int edad = leert.leerEntero();
            //APersonas[cord.fila][cord.columna].setEdad(edad);
            p.setEdad(edad);
            
            return true;
            
        } else {
            System.out.println("Persona no Encontrada");
            return false;
        }
    }
    
    public boolean Eliminar(String nombre) {
        //buscar por posicion
        //si lo encuentra mostrar informacion y preguntar si desea eliminar a la persona
        //si si deseas eliminarla entonces asigno una persona vacia y sino regreso false
        //si no lo encuentra regresar false

        if (BuscarPos(nombre) != null) {
            cordenadas search = BuscarPos(nombre);
            int fil = search.getFila();
            int col = search.getColumna();
            persona e = APersonas[fil][col];
            e.setEdad(0);
            e.setNombre(null);
            e.setCod(-1);
            e.setApellido("");
            return true;
        }
        return false;
    }
    
    public persona BuscarCodigo(int cod) {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null && APersonas[y][x].getNombre() != null) {
                    if (APersonas[y][x].getCod() == cod) {
                        //System.out.println("posicion Fila "+y+" col "+x+":"+APersonas[y][x].getNombre());
                        return APersonas[y][x];
                    }
                }
                
            }
        }
        
        return null;
    }
    
    public void inicializar() {
        for (int y = 0; y < LimiteF; y++) {
            for (int x = 0; x < LimiteC; x++) {
                
                APersonas[y][x] = new persona();
                
            }
        }
    }
}

class cordenadas {
    
    public int fila;
    public int columna;
    
    public cordenadas(int x, int y) {
        fila = y;
        columna = x;
    }
    
    public int getFila() {
        return fila;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public int getColumna() {
        return columna;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }
}
