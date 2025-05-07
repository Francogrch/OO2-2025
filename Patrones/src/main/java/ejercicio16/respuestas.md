Tareas:

1. Descargue el proyecto y pruebe los diferentes Filtros

2. Analice el código y documente el proyecto con un Diagrama de Clases

3. Evalúe cuál de los siguientes patrones mejor describe el diseño de los Filtros: TemplateMethod, Strategy, Decorator. Para realizar la evaluación se sugiere contestar las siguientes preguntas aplicadas a cada uno de los patrones:

a. ¿El objetivo del patrón se distingue en el diseño? Elabore en un párrafo.
El decorador es quien lo describe mejor, el objetivo del patron es decorar o cambiar la skin del objeto y eso lo cumple.

b. ¿La estructura del proyecto coincide con la estructura y los participantes del patrón? Elabore en un párrafo.
La estructura no concuerda, ya que los filtros de aplican de manera manual, y no utilizando mensajes y polimorfismo

c. En el caso que el patrón coincida, puede distinguir un “smell” o algo que se aleja del patrón presentado en el libro?
Si, el mal olor esta en recorrer una lista de filtros activas para poder cambiar esta skin.

Se requiere crear el filtro Monochrome. El pseudo código para crear una imagen  monocrome es el siguiente:
Parámetro de entrada: BufferedImage image

    public class Monochrome extends Filter {
      public BufferedImage filter(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
          for (int y = 0; y < image.getHeight(); y++) {
            int pixel = image.getRGB(x, y);
            int alpha = (pixel >> 24) & 0xff;
            int red = (pixel >> 16) & 0xff;
            int green = (pixel >> 8) & 0xff;
            int blue = pixel & 0xff;
            int avg = (red + green + blue) / 3;
            pixel = (alpha << 24) | (avg << 16) | (avg << 8) | avg;
            image.setRGB(x, y, pixel);
          }
        }
        return image;
      }
    }

ademas, hay que agregarlo en PNGFilterLauncher, en el metodo inicialiceFilter:

    filters.put("--monochrome", new Monochrome());
