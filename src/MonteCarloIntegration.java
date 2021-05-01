
public class MonteCarloIntegration {

    // f(x) = sin(x)
    public static double seno(double x){
        return Math.sin(x);
    }
    // seja [a, b] um intervalo real onde a < b
    public static double MonteCarloIntegration(double a, double b, long iterations){
        if(a>b){
            //inverte a e b se o intervalo for invertido
            return MonteCarloIntegration(b , a, iterations);
        }
        double somaFuncao = 0, randon= 0, integralSeno=0;

        //escolhe "iterations" pontos aleatórios
        for (long i = 1; i<=iterations; i++){
            randon = Math.random();
            // (b-a) = intervalo na reta real entre a e b
            // randon = numero randomico entre 0 e 1
            // ((b-a)*randon) = numero randomico no intervalo entre a e b 
            // a+((b-a)*randon) = adiciona a distancia do intervalo da reta Y
            somaFuncao = somaFuncao + seno(a+((b-a) * randon));
            // soma = soma de todos os números 
        }
        integralSeno = (b-a)*(somaFuncao/iterations);
        // soma/iterations = média dos valores obtidos 
        // b-a*(soma/iterations) = aproximação da área da função usando média*intervalo
        return integralSeno;
    }

    public static void main(String[] args){
        System.out.println("O valor estimado é: " + MonteCarloIntegration(0, 1, 1000000));
    }
}