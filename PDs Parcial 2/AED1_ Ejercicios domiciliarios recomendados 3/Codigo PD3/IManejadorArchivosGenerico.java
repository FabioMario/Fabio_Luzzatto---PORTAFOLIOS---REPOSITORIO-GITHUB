public interface IManejadorArchivosGenerico {
    public void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo);
    public String[] leerArchivo(String nombreCompletoArchivo);
}
