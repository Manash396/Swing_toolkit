

public class Neuron {

    private double[] weights;
    private double bias;

    public Neuron(int inputSize) {
        weights = new double[inputSize];
        for (int i = 0; i < inputSize; i++) {
            weights[i] = Math.random() - 0.5;  // Random initialization
        }
        bias = Math.random() - 0.5;
    }

    public double activate(double[] inputs) {
        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += weights[i] * inputs[i];
        }
        return sigmoid(sum);
    }

    public double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public double sigmoidDerivative(double x) {
        return x * (1 - x);
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }
}
