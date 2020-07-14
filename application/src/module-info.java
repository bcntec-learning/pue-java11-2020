module app1 {
    requires facturacion;
    requires ventas;
    //requires comunes;
    requires transitive comunes;
}