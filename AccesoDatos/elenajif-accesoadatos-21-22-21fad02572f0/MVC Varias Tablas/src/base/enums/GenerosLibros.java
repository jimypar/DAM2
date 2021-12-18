package base.enums;

/**
 * Esta clase enum enumera las constantes con las que se rellena
 * el JComoboBox comboGenero de la vista.
 * Representan los gÃ©neros literarios que existen.
 */
public enum GenerosLibros {
    NOVELAFANTASIA("FantasÃ­a"),
    NOVELACFICCION("Ciencia-ficciÃ³n"),
    NOVELAAUTOFICTION("AutoficciÃ³n"),
    NOVELATHRILLER("Suspense"),
    NOVELATERROR("Terror"),
    NOVELAHISTORICA("HistÃ³rico"),
    NOVELAAVENTURAS("Aventuras"),
    POLICIACA("Policiaco"),
    NOVELAROMANCE("Romance"),
    NOVELAJUVENIL("Juvenil"),
    NOVELAINFANTIL("Infantil"),
    COMIC("CÃ³mic"),
    MANGA("Manga"),
    RELATO("Relato"),
    MICRORELATO("Microrrelato"),
    CUENTOHADAS("Cuento de hadas"),
    RELATOMODERNO("Relato moderno"),
    AFORISMOS("Aforismos"),
    POESIA("PoesÃ­a"),
    ENSAYO("Ensayo");

    private String valor;

    GenerosLibros(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}