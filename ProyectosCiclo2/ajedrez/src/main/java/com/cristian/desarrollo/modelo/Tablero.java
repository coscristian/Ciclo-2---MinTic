package com.cristian.desarrollo.modelo;
//Tarea: Convertir todos los atributos a privados
//Tarea2: Ponerle a todas las clases su respectivo constructor
public class Tablero {

    private Jugador jugador1;
    private Jugador jugador2;
    
    private Casilla[][] casillas;

    // Constructor 1
    public Tablero(Jugador j1, Jugador j2){
        jugador1 = j1;
        jugador2 = j2;
        
        // Cargar las casillas con su color
        inicializarCasillas();

        // Ubicar fichas en su posicion inicial
        ubicarFichas();
    }

    // Segundo constructor: 
    public Tablero(String nombre1, String nombre2){
        // Sobrecarga de metodos: los constructores con el mismo nombre hacen tareas diferentes dependiendo del tipo de dato
        // Llama al constructor de la misma clase que recibe dos parametros de tipo jugador
        this(new Jugador(nombre1, Color.BLANCO), new Jugador(nombre2, Color.BLANCO));

        // Cargar las casillas con su color
        inicializarCasillas();

        // Ubicar fichas en su posicion inicial
        ubicarFichas();
    }

/*     private void crearFicha(Color color, Integer fila, Integer columna){
        var letraColumna = letraDeColumna(columna);

        if( fila == 0 || fila == 7){    // Filas en la que varian las fichas a colocar
            switch (letraColumna) {   //Verifico que columna es para crear las fichas
                case 'a':
                    var torre = new Torre(color, fila, 'a'); //Creo una ficha Torre
                    casillas[fila][columna].setFicha(torre);    // En el array de casillas, pongo la ficha torre
                    break;
                case 'b':
                    var caballo = new Caballo(color, fila, 'b'); //Creo una ficha caballo
                    casillas[fila][columna].setFicha(caballo);   
                    break;
                case 'c':
                    var alfil = new Alfil(color, fila, 'c');
                    casillas[fila][columna].setFicha(alfil);
                    break;
                case 'd':
                    var reina = new Reina(color, fila, 'd');
                    casillas[fila][columna].setFicha(reina);
                    break;
                case 'e':
                    var rey = new Rey(color, fila, 'e');
                    casillas[fila][columna].setFicha(rey);
                    break;
                case 'f':
                    var alfil2 = new Alfil(color, fila, 'f');
                    casillas[fila][columna].setFicha(alfil2);
                    break;
                case 'g':
                    var caballo2 = new Caballo(color, fila, 'g'); //Creo una ficha caballo
                    casillas[fila][columna].setFicha(caballo2);   
                    break;
                case 'h':
                    var torre2 = new Torre(color, fila, 'h'); 
                    casillas[fila][columna].setFicha(torre2);  
                    break;
            }
        }else if (fila == 1 || fila == 6){   //Fichas en las que inicialmente hay solo peones
            var peon = new Peon(color, fila, letraColumna);
            casillas[fila][columna].setFicha(peon);
        }
    } */

    private void ubicarFichas(){
        //Fichas Negras
/*         for (Integer fila = 0; fila < 2; fila++) {
            for (Integer columna = 0; columna < 8; columna++){
                crearFicha(Color.NEGRO, fila, columna);
            }
        }

        //Fichas blancas
        for (Integer fila = 6; fila < 8; fila++) {
            for (Integer columna = 0; columna < 8; columna++){
                crearFicha(Color.BLANCO, fila, columna);
            }
        } */

        //Implementacion profesor
        casillas[0][0].setFicha(new Torre(Color.BLANCO));
        casillas[0][1].setFicha(new Caballo(Color.BLANCO));
        casillas[0][2].setFicha(new Alfil(Color.BLANCO));
        casillas[0][3].setFicha(new Reina(Color.BLANCO));
        casillas[0][4].setFicha(new Rey(Color.BLANCO));
        casillas[0][5].setFicha(new Alfil(Color.BLANCO));
        casillas[0][6].setFicha(new Caballo(Color.BLANCO));
        casillas[0][7].setFicha(new Torre(Color.BLANCO));

        for (int i = 0; i < 8; i++) {
            casillas[1][i].setFicha(new Peon(Color.BLANCO));
            casillas[6][i].setFicha(new Peon(Color.NEGRO));
        }

        casillas[7][0].setFicha(new Torre(Color.NEGRO));
        casillas[7][1].setFicha(new Caballo(Color.NEGRO));
        casillas[7][2].setFicha(new Alfil(Color.NEGRO));
        casillas[7][3].setFicha(new Reina(Color.NEGRO));
        casillas[7][4].setFicha(new Rey(Color.NEGRO));
        casillas[7][5].setFicha(new Alfil(Color.NEGRO));
        casillas[7][6].setFicha(new Caballo(Color.NEGRO));
        casillas[7][7].setFicha(new Torre(Color.NEGRO));
    }

    private Character letraDeColumna(Integer columna){
        return "abcdefgh".charAt(columna);
    }

    private void inicializarCasillas(){
        casillas = new Casilla[8][8];
        for (var fila = 0; fila < 8; fila++) {
            for (var columna = 0; columna < 8; columna++) {
                var color = (fila + columna) % 2 == 0 ? Color.NEGRO : Color.BLANCO;
                casillas[fila][columna] = new Casilla(fila, letraDeColumna(columna), color);
            }
        }
    }

    public void enroque(){
        // TODO: Falta implementar este metodo
    }

    public void jaque(){
        // TODO: Falta implementar este metodo
    }

    public void jaqueMate(){
        // TODO: Falta implementar este metodo
    }

    public void imprimirTablero() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(casillas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    
    
}
