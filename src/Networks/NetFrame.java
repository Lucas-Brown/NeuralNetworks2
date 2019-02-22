package Networks;

import Networks.ActivationFunction;

public abstract class NetFrame {

    public static double LEARNING_RATE = 0.003;

    public final ActivationFunction ACTIVATION_FUNCTION;
    public final double MULTIPLIER;

    public final int NETWORK_LAYER_SIZES[], INPUT_SIZE, OUTPUT_SIZE, NETWORK_SIZE;


    public NetFrame(int... NETWORK_LAYER_SIZES){
        this(new ActivationFunction.Sigmoid(), NETWORK_LAYER_SIZES);
    }

    public NetFrame(ActivationFunction af, int... NETWORK_LAYER_SIZES){
        this(af, 1, NETWORK_LAYER_SIZES);
    }

    public NetFrame(ActivationFunction af, double multiplier, int[] NETWORK_LAYER_SIZES){
        this.MULTIPLIER = multiplier;
        this.NETWORK_LAYER_SIZES = NETWORK_LAYER_SIZES;
        this.INPUT_SIZE = NETWORK_LAYER_SIZES[0];
        this.NETWORK_SIZE = NETWORK_LAYER_SIZES.length;
        this.OUTPUT_SIZE = NETWORK_LAYER_SIZES[NETWORK_SIZE - 1];
    }

    public abstract double[] calculate(double... input);

    protected abstract void loops(ActivationFunction AF);

    public abstract void train(TrainSet set, int loops, int batch_size);

    public void train(TrainSet set, int loops, int batch_size, int saveInterval, String file) {
        if (set.INPUT_SIZE != this.INPUT_SIZE || set.OUTPUT_SIZE != this.OUTPUT_SIZE) {
            return;
        }
        try {
            for (int i = 0; i < loops / saveInterval; i++) {
                this.train(set, loops / saveInterval, batch_size);
                this.saveNetwork(file);
            }
            this.saveNetwork(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void train(double[] input, double[] target, double eta);

    public double MSE(double[] input, double[] target) {
        if (input.length != this.INPUT_SIZE || target.length != this.OUTPUT_SIZE) {
            return 0;
        }
        this.calculate(input);
        double v = 0;
        for (int i = 0; i < target.length; i++) {
            v += (target[i] - this.output[this.NETWORK_SIZE - 1][i]) * (target[i] - this.output[this.NETWORK_SIZE - 1][i]);
        }
        return v / (2d * target.length);
    }

    public double MSE(TrainSet set) {
        double v = 0;
        for (int i = 0; i < set.size(); i++) {
            v += MSE(set.getInput(i), set.getOutput(i));
        }
        return v / set.size();
    }

    protected abstract void backpropError(double[] target);

    protected void updateWeights(double eta) {
        for (int layer = 1; layer < this.NETWORK_SIZE; layer++) {
            for (int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron++) {

                double delta = -eta * this.error_signal[layer][neuron];
                this.bias[layer][neuron] += delta;

                for (int prevNeuron = 0; prevNeuron < this.NETWORK_LAYER_SIZES[layer - 1]; prevNeuron++) {
                    this.weights[layer][neuron][prevNeuron] += delta * this.output[layer - 1][prevNeuron];
                }
            }
        }
    }

    public abstract void saveNetwork(String fileName);
}
