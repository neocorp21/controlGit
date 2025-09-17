package org.example;

// DTO para una fila
public class FilaExcelDTO {
    private String columnaA;
    private String columnaB;
    private String columnaC;
    private String columnaD;
    private String columnaE;
    private String columnaF;
    private String columnaG;
    private String columnaH;
    private String columnaI;
    private String columnaJ;

    // getters y setters
    public String getColumnaA() { return columnaA; }
    public void setColumnaA(String columnaA) { this.columnaA = columnaA; }

    public String getColumnaB() { return columnaB; }
    public void setColumnaB(String columnaB) { this.columnaB = columnaB; }

    public String getColumnaC() { return columnaC; }
    public void setColumnaC(String columnaC) { this.columnaC = columnaC; }

    public String getColumnaD() { return columnaD; }
    public void setColumnaD(String columnaD) { this.columnaD = columnaD; }

    public String getColumnaE() { return columnaE; }
    public void setColumnaE(String columnaE) { this.columnaE = columnaE; }

    public String getColumnaF() { return columnaF; }
    public void setColumnaF(String columnaF) { this.columnaF = columnaF; }

    public String getColumnaG() { return columnaG; }
    public void setColumnaG(String columnaG) { this.columnaG = columnaG; }

    public String getColumnaH() { return columnaH; }
    public void setColumnaH(String columnaH) { this.columnaH = columnaH; }

    public String getColumnaI() { return columnaI; }
    public void setColumnaI(String columnaI) { this.columnaI = columnaI; }

    public String getColumnaJ() { return columnaJ; }
    public void setColumnaJ(String columnaJ) { this.columnaJ = columnaJ; }

    @Override
    public String toString() {
        return "FilaExcelDTO{" +
                "A='" + columnaA + '\'' +
                ", B='" + columnaB + '\'' +
                ", C='" + columnaC + '\'' +
                ", D='" + columnaD + '\'' +
                ", E='" + columnaE + '\'' +
                ", F='" + columnaF + '\'' +
                ", G='" + columnaG + '\'' +
                ", H='" + columnaH + '\'' +
                ", I='" + columnaI + '\'' +
                ", J='" + columnaJ + '\'' +
                '}';
    }
}