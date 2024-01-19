public class Producto {
        private String nombre;
        private double precio;
        private int reference;
        private int stock;
        private int categoria;
    
        public Producto(String nombre, double precio, int reference, int stock, int categoria) {
            this.nombre = nombre;
            this.precio = precio;
            this.reference = reference;
            this.stock = stock;
            this.categoria = categoria;
        }
    
        public int getReference() {
            return reference;
        }
    
        public int getCategoria() {
            return categoria;
        }
    
        @Override
        public String toString() {
            return "Producto{" +
                    "nombre='" + nombre + '\'' +
                    ", precio=" + precio +
                    ", reference=" + reference +
                    ", stock=" + stock +
                    ", categoria=" + categoria +
                    '}';
        }
}