package Principal;

public class ModelSalario {
    
    private double salarioBruto, fgts, inss, impostoRenda, salarioLiquido;

    public ModelSalario(double salarioBruto) {
        //this.salarioBruto = salarioBruto;
        this.setSalarioBruto(salarioBruto);
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getFgts() {
        return fgts;
    }

    public void setFgts(double fgts) {
        this.fgts = fgts;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getImpostoRenda() {
        return impostoRenda;
    }

    public void setImpostoRenda(double impostoRenda) {
        this.impostoRenda = impostoRenda;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
    
    public void CalcularFGTS(double salarioBruto) {
        
        this.setFgts(salarioBruto * 0.08);
    }
    
    public void CalcularINSS(double salarioBruto) {
        
        if (salarioBruto <= 1045) {
            this.setInss(salarioBruto * 0.075);
        } else if (salarioBruto >= 1045.01 && salarioBruto <= 2089.60) {
            this.setInss(salarioBruto * 0.09);
        } else if (salarioBruto >= 2089.61 && salarioBruto <= 3134.40) {
            this.setInss(salarioBruto * 0.12);
        } else if (salarioBruto >= 3134.41 && salarioBruto <= 6101.06) {
            this.setInss(salarioBruto * 0.14);    
        } else {
            this.setInss(6101.06 * 0.14);
        }
    }
    
    public void CalcularImpostoRenda(double salarioBruto) {
        
        if (salarioBruto <= 1903.98) {
            this.setImpostoRenda(0);
        } else if (salarioBruto >= 1903.99 && salarioBruto <= 2826.65) {
            this.setImpostoRenda((salarioBruto * 0.075) - 142.80);
        } else if (salarioBruto >= 2826.66 && salarioBruto <= 3751.05) {
            this.setImpostoRenda((salarioBruto * 0.15) - 354.80);
        } else if (salarioBruto >= 3751.06 && salarioBruto <= 4664.68) {
            this.setImpostoRenda((salarioBruto * 0.225) - 636.13);
        } else if (salarioBruto >= 4664.68) {
            this.setImpostoRenda((salarioBruto * 0.275) - 868.36);
        }
    }
    
    public void CalcularSalarioLiquido(double salarioBruto, double inss, double impostoRenda) {
        this.setSalarioLiquido(salarioBruto - (inss + impostoRenda));
    }
}