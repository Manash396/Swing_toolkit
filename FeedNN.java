import java.util.Arrays;
import java.util.Scanner;

public class FeedNN {
    private Neuron[] hiddenLayer;
    private Neuron[] outputLayer;
    private double learningRate;

    public FeedNN(int inputSize, int hiddenSize, int outputSize, double learningRate) {
        hiddenLayer = new Neuron[hiddenSize];
        outputLayer = new Neuron[outputSize];
        for (int i = 0; i < hiddenSize; i++) {
            hiddenLayer[i] = new Neuron(inputSize);
        }
        for (int i = 0; i < outputSize; i++) {
            outputLayer[i] = new Neuron(hiddenSize);
        }
        this.learningRate = learningRate;
    }

    public double[] feedForward(double[] inputs) {
        double[] hiddenOutputs = new double[hiddenLayer.length];
        for (int i = 0; i < hiddenLayer.length; i++) {
            hiddenOutputs[i] = hiddenLayer[i].activate(inputs);
        }

        double[] outputs = new double[outputLayer.length];
        for (int i = 0; i < outputLayer.length; i++) {
            outputs[i] = outputLayer[i].activate(hiddenOutputs);
        }
        return outputs;
    }

    public void train(double[] inputs, double[] targetOutputs) {
        // Feed forward
        double[] hiddenOutputs = new double[hiddenLayer.length];
        for (int i = 0; i < hiddenLayer.length; i++) {
            hiddenOutputs[i] = hiddenLayer[i].activate(inputs);
        }

        double[] outputs = new double[outputLayer.length];


        for (int i = 0; i < outputLayer.length; i++) {
            outputs[i] = outputLayer[i].activate(hiddenOutputs);
          
        }
      
    
        // Calculate output layer error
        double[] outputErrors = new double[outputLayer.length];
        for (int i = 0; i < outputLayer.length; i++) {
            outputErrors[i] = targetOutputs[i] - outputs[i];
        }
        //   System.out.println(Arrays.toString(outputErrors));

        // Calculate hidden layer error
        double[] hiddenErrors = new double[hiddenLayer.length];
        for (int i = 0; i < hiddenLayer.length; i++) {
            hiddenErrors[i] = 0;
            for (int j = 0; j < outputLayer.length; j++) {
                hiddenErrors[i] += outputErrors[j] * outputLayer[j].sigmoidDerivative(outputs[j]) * outputLayer[j].getWeights()[i];
            }
            // System.out.println(hiddenErrors[i]);
        }

        // Update output layer weights
        for (int i = 0; i < outputLayer.length; i++) {
            double[] weights = outputLayer[i].getWeights();
            for (int j = 0; j < weights.length; j++) {
                weights[j] += learningRate * outputErrors[i] * outputLayer[i].sigmoidDerivative(outputs[i]) * hiddenOutputs[j];
            }
            outputLayer[i].setBias(outputLayer[i].getBias() + learningRate * outputErrors[i] * outputLayer[i].sigmoidDerivative(outputs[i]));
        }

        // Update hidden layer weights
        for (int i = 0; i < hiddenLayer.length; i++) {
            double[] weights = hiddenLayer[i].getWeights();
            for (int j = 0; j < weights.length; j++) {
                weights[j] += learningRate * hiddenErrors[i] * hiddenLayer[i].sigmoidDerivative(hiddenOutputs[i]) * inputs[j];
            }
            hiddenLayer[i].setBias(hiddenLayer[i].getBias() + learningRate * hiddenErrors[i] * hiddenLayer[i].sigmoidDerivative(hiddenOutputs[i]));
        }
    }

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         double[][] inputs = {
            {0}, 
            {1}, 
        };
         double[][] outputs = {
            {0,1}, 
            {1,0}, 
        }; 

        FeedNN nn = new FeedNN(1, 2, 2, 1);   
        while(true){
            System.out.println("\nAn Artificial Nueral Network for Identifying whether a Integer is negative or positive.\n");
            System.out.println("choose an option :-\n 1) For entering an Integer\n 2) For training the model");
            System.out.print("Enter: ");
            int op = in.nextInt();
            
            if(op==2){
                // 1000 epoch for tarining 
                for (int epoch = 0; epoch < 1000; epoch++) {
                    for (int i = 0; i < inputs.length; i++) {
                        nn.train(inputs[i], outputs[i]);
                    }  
            }
            System.out.println("\n\nTraining is done with dataset: \n Inputs: "+Arrays.deepToString(inputs)+"\n Outputs : "+Arrays.deepToString(outputs));
            System.out.println("\n\n");

            }
            if(op==1){
                System.out.println("Enter the value: ");
                int val = in.nextInt();
                System.out.println("Input :"+val);
                double ans[];
                if(val>0){
                 ans = nn.feedForward(inputs[1]); 
                System.out.println(Arrays.toString(ans));
                if(ans[0]<ans[1]){
                    System.out.println("Negative Integer");
                }
                if(ans[0]>ans[1]){
                    System.out.println("Positive Integer");
                }
                }
                if(val<0){
                 ans = nn.feedForward(inputs[0]);
                System.out.println(Arrays.toString(ans));
                if(ans[0]<ans[1]){
                    System.out.println("Negative Integer\n\n");
                }
                if(ans[0]>ans[1]){
                    System.out.println("Positive Integer\n\n");
                }
                }
              //   
                  
            }

        }


   
    }
}
