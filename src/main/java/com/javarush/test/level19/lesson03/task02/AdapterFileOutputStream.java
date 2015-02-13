package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fout;

    public AdapterFileOutputStream(FileOutputStream fout) {
        this.fout = fout;
    }

    @Override
    public void flush() throws IOException {
        fout.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fout.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fout.close();
    }
}

