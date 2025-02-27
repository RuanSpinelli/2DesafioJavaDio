package candidatura;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        /*
        ProcessoSeletivo.analisarCandidato(1900.0);
        ProcessoSeletivo.analisarCandidato(2200.0);
        ProcessoSeletivo.analisarCandidato(2000.0);
        */
        
        //ProcessoSeletivo.selecionandoCandidato();

        //imprimirSelecionados();


        String[] candidatos = {"Felipe", "Kaua", "Fernando", "Marcelo", "Bianca"};


        for (String candidato: candidatos){
            entrandoEmContato(candidato);

        }

    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas =1;

        boolean continuaTentando = true;

        boolean atendeu = false;


        do {
            atendeu = atender();
            
            continuaTentando = !atendeu;

            if (continuaTentando) tentativasRealizadas++;
            
            else System.out.println("CONTATO REALIZADO COM SUCESSO");


        } while (continuaTentando && tentativasRealizadas < 3);

        if (atendeu){
            System.out.println("Conseguiu entrar em contato com "+candidato+" em "+ tentativasRealizadas +
            " tentativas");
        } else {
            System.out.println("Não conseguiu entrar em contato com o usuário. Numéro máximo de tentativas = "+ 
            tentativasRealizadas);
        }


    }


    static boolean atender(){
        return new Random().nextInt(3)==1;
    }


    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato!");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta!");
        } else {
            System.out.println("Aguardar o resultado dos outros candidatos!");
        }
    }

    static void selecionandoCandidato(){
        String[] candidatos = {"Felipe", "Kaua", "Fernando", "Marcelo", "Bianca"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;

        double salarioBase = 2000.0;

        while (candidatosSelecionados < candidatos.length && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + 
            " solicitou este valor de salário = R$" + salarioPretendido);

            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }

            candidatosAtual++;
        }

        if (candidatosAtual >= candidatos.length) {
            System.out.println("Todos os candidatos foram processados.");
        }
    }

    static void imprimirSelecionados(){
        String[] candidatos = {"Felipe", "Kaua", "Fernando", "Marcelo", "Bianca"};


        System.out.println("Imprimindo os candidatos com indice:\n");

        for (int i = 0; i < candidatos.length; i++){
            System.out.println("Candidato = "+candidatos[i]+ " index = "+i);


        }

        System.out.println("Imprimindo os candidatos sem se preocupar com o indice:\n");

        for (String candidato:candidatos){
            System.out.println(candidato);
        }
    }



    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }
}
