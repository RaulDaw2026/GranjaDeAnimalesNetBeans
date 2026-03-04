/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    /**
 * Constructor de la clase Animal.
 * Crea un nuevo objeto Animal con un código identificativo, fecha de nacimiento, sexo y peso.
 * Realiza validaciones sobre los parámetros y lanza IllegalArgumentException si alguno no es válido.
 *
 * @param codigo código identificativo del animal (5 caracteres alfanuméricos en minúscula: [0-9a-z]{5})
 * @param fechaNacimiento fecha de nacimiento en formato ISO-8601 válido (yyyy-MM-dd)
 * @param sexo sexo del animal: 'M' o 'H'
 * @param peso peso del animal en kilogramos, debe ser mayor que 0
 * @throws IllegalArgumentException si el código, sexo, peso o fecha no son válidos
 */
    
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

 /**
 * Devuelve el codigo que identifica al animal.
 *
 * @return código del animal
 */
    
    public String getCodigo() {
        return codigo;
    }

   /**
 * Modifica el codigo que identifica al animal.
 *
 * @param codigo nuevo código (5 caracteres alfanuméricos en minúscula)
 * @throws IllegalArgumentException si el codigo no cumple el patrón [0-9a-z]{5}
 */
    
    
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }
/**
 * Devuelve la fecha de nacimiento del animal.
 *
 * @return fecha de nacimiento
 */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
/**
 * Modifica la fecha de nacimiento del animal.
 *
 * @param fechaNacimiento fecha en formato ISO-8601 (yyyy-MM-dd)
 * @throws IllegalArgumentException si la fecha no es valida o no se puede parsear
 */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }
/**
 * Devuelve el sexo del animal.
 *
 * @return 'M' o 'H'
 */
    public char getSexo() {
        return sexo;
    }
/**
 * Modifica el sexo del animal.
 *
 * @param sexo 'M' o 'H'
 * @throws IllegalArgumentException si el sexo no es 'M' ni 'H'
 */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }
/**
 * Devuelve el peso del animal.
 *
 * @return peso en kilogramos
 */
    public double getPeso() {
        return peso;
    }
/**
 * Modifica el peso del animal.
 *
 * @param peso nuevo peso en kilogramos, debe ser mayor que 0
 * @throws IllegalArgumentException si el peso es menor o igual que 0
 */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }
/**
 * Calcula el codigo hash del animal en función de sus atributos.
 *
 * @return valor hash del objeto
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }
/**
 * Compara este animal con otro objeto para determinar si son iguales.
 * Se considera igual si coinciden código, fecha de nacimiento, sexo y peso.
 *
 * @param obj objeto a comparar
 * @return true si son iguales; false en caso contrario
 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }
/**
 * Devuelve una representación en texto del animal con sus atributos.
 *
 * @return representación textual del animal
 */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }
/**
 * Devuelve el sonido característico del animal.
 *
 * @return sonido del animal
 */
    public abstract String hacerSonido();
/**
 * Devuelve una cadena que representa la reacción del animal cuando se alegra.
 *
 * @return reacción de alegría
 */
    public abstract String alegrarse();
/**
 * Devuelve una cadena que representa la reacción del animal cuando se enfada.
 *
 * @return reacción de enfado
 */
    public abstract String enfadarse();
/**
 * Indica el tipo de animal (ejemplo, "Perro" o "Gato").
 *
 * @return tipo o nombre del animal
 */
    public abstract String queSoy();

}
