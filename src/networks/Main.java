package networks;

import networks.Network;
import trainSet.ExampleSets;
import trainSet.TrainSet;

class Main{

    public static void main(String[] args) throws Exception {
        Network net = Network.loadNetwork("NetSave.txt");// = new Network(new ActivationFunction.Linear(), 100, new int[]{2, 3, 2});
        TrainSet set = ExampleSets.perfectLinear(net.INPUT_SIZE, net.OUTPUT_SIZE, net.MULTIPLIER);

        net.train(set, 100000, set.size(), "NetSave.txt", 1000);
        net.printResults(set);
    }
}