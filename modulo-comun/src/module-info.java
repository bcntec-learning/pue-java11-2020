module comunes {
    exports modulos.readers;
    exports modulos.util;
    provides modulos.readers.LogoReader with modulos.impl.LogoReaderImpl12;
    uses modulos.readers.LogoReader;
}