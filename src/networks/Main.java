package networks;

import networks.Network;
import trainSet.ExampleSets;
import trainSet.TrainSet;

class Main{

    public static void main(String[] args){
        Network net = new Network(new ActivationFunction.TanH(), 100, new int[]{2, 3, 1});
        TrainSet set = ExampleSets.ImperfectLinear();

        net.train(set, 10000, set.size());
        net.printResults(set);
    }
}