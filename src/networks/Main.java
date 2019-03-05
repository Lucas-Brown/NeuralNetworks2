package networks;

import networks.Network;
import trainSet.ExampleSets;
import trainSet.TrainSet;

class Main{

    public static void main(String[] args){
        Network net = new Network(new ActivationFunction.Sigmoid(), 100, new int[]{2, 3, 2});
        TrainSet set = ExampleSets.perfectLinear(net.INPUT_SIZE, net.OUTPUT_SIZE, net.MULTIPLIER);

        net.train(set, 10000000, set.size());
        System.out.println(net.MSE(set));
        net.printResults(set);
    }
}