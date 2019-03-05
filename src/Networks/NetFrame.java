package networks;

import networks.ActivationFunction;
import trainSet.TrainSet;

public abstract class NetFrame {

    public static final double LEARNING_RATE = 0.0000003;

    protected final ActivationFunction ACTIVATION_FUNCTION;
    protected final double MULTIPLIER;

    protected final int NETWORK_LAYER_SIZES[], INPUT_SIZE, OUTPUT_SIZE, NETWORK_SIZE;

    protected double[][] output, bias;
    protected double[][][] weights;

    public NetFrame(int... NETWORK_LAYER_SIZES){
        this(new ActivationFunction.Sigmoid(), NETWORK_LAYER_SIZES);
    }

    public NetFrame(ActivationFunction activationFunction, int... NETWORK_LAYER_SIZES){
        this(activationFunction, 1, NETWORK_LAYER_SIZES);
    }

    public NetFrame(ActivationFunction activationFunction, double multiplier, int[] NETWORK_LAYER_SIZES){
    	if(multiplier <= 0) {
            System.err.println("multiplier cannot be less than or equal to zero");
            this.MULTIPLIER = 1;
        } else {
            this.MULTIPLIER = multiplier;
        }
        this.ACTIVATION_FUNCTION = activationFunction;
        this.NETWORK_LAYER_SIZES = NETWORK_LAYER_SIZES;
        this.INPUT_SIZE = NETWORK_LAYER_SIZES[0];
        this.NETWORK_SIZE = NETWORK_LAYER_SIZES.length;
        this.OUTPUT_SIZE = NETWORK_LAYER_SIZES[NETWORK_SIZE - 1];

        this.output = new double[NETWORK_SIZE][];
        this.weights = new double[NETWORK_SIZE][][];
        this.bias = new double[NETWORK_SIZE][];

        for (int i = 0; i < NETWORK_SIZE; i++) {
            this.output[i] = new double[NETWORK_LAYER_SIZES[i]];
            this.bias[i] = NetworkTools.createRandomArray(NETWORK_LAYER_SIZES[i],  -0.5, 0.7);

            if (i > 0) {
                this.weights[i] = NetworkTools.createRandomArray(NETWORK_LAYER_SIZES[i], NETWORK_LAYER_SIZES[i - 1], -0.5, 0.7);
            }
        }
    }

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

    protected abstract void updateWeights(double eta);
    protected abstract void backpropError(double[] target);
    protected abstract void loops();
    public abstract void train(double[] input, double[] target, double eta);
    public abstract void train(TrainSet set, int loops, int batch_size);
    public abstract void saveNetwork(String fileName);
    public abstract double[] calculate(double... input);
}