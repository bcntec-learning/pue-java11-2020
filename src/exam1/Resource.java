package exam1;

public @interface Resource {
    String name(); //requerido
    int priority() default 0;
}
