package dev.android.mobile.santos.medianotas.model;

public class Notas {
    private String nomeAluno;
    private String disciplina;
    private double n1;
    private double n2;
    private double n3;
    private double n4;
    private double mediaNotas;
    private String resultado;

    public Notas() {
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }

    public double getN4() {
        return n4;
    }

    public void setN4(double n4) {
        this.n4 = n4;
    }

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double media(double n1, double n2, double n3, double n4) {
        double mediaNotas = (n1+n2+n3+n4)/4;
        return mediaNotas;
    }
}
