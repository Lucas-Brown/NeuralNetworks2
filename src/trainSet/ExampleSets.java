package trainSet;

public class ExampleSets{
    
    /*
     * Provides a Trainset of inperfect data on an input of 2 
     * and output of 1
     */
	public static TrainSet ImperfectLinear() {
        TrainSet set = new TrainSet(2, 1);
        set.addData(new double[]{0, 0}, new double[]{0});
        set.addData(new double[]{0, 0.2}, new double[]{0});
        set.addData(new double[]{0, 0.4}, new double[]{0});
        set.addData(new double[]{0, 0.6}, new double[]{0});
        set.addData(new double[]{0, 0.8}, new double[]{0});
        set.addData(new double[]{0, 1.0}, new double[]{0});

        set.addData(new double[]{10, 0.4}, new double[]{9});
        set.addData(new double[]{15, 0.4}, new double[]{14});
        set.addData(new double[]{20, 0.4}, new double[]{18});
        set.addData(new double[]{25, 0.4}, new double[]{23});
        set.addData(new double[]{30, 0.4}, new double[]{27});
        set.addData(new double[]{35, 0.4}, new double[]{32});
        set.addData(new double[]{40, 0.4}, new double[]{37});
        set.addData(new double[]{45, 0.4}, new double[]{42});
        set.addData(new double[]{50, 0.4}, new double[]{47});
        set.addData(new double[]{55, 0.4}, new double[]{52});
        set.addData(new double[]{60, 0.4}, new double[]{57});
        set.addData(new double[]{65, 0.4}, new double[]{62});
        set.addData(new double[]{70, 0.4}, new double[]{67});
        set.addData(new double[]{75, 0.4}, new double[]{71});
        set.addData(new double[]{80, 0.4}, new double[]{76});
        set.addData(new double[]{85, 0.4}, new double[]{81});
        set.addData(new double[]{90, 0.4}, new double[]{85});

        set.addData(new double[]{10, 0.6}, new double[]{9});
        set.addData(new double[]{15, 0.6}, new double[]{14});
        set.addData(new double[]{20, 0.6}, new double[]{17});
        set.addData(new double[]{25, 0.6}, new double[]{22});
        set.addData(new double[]{30, 0.6}, new double[]{27});
        set.addData(new double[]{35, 0.6}, new double[]{32});
        set.addData(new double[]{40, 0.6}, new double[]{37});
        set.addData(new double[]{45, 0.6}, new double[]{41});
        set.addData(new double[]{50, 0.6}, new double[]{46});
        set.addData(new double[]{55, 0.6}, new double[]{51});
        set.addData(new double[]{60, 0.6}, new double[]{56});
        set.addData(new double[]{65, 0.6}, new double[]{60});
        set.addData(new double[]{70, 0.6}, new double[]{65});
        set.addData(new double[]{75, 0.6}, new double[]{70});
        set.addData(new double[]{80, 0.6}, new double[]{75});
        set.addData(new double[]{85, 0.6}, new double[]{79});
        set.addData(new double[]{90, 0.6}, new double[]{84});

        set.addData(new double[]{10, 0.8}, new double[]{8});
        set.addData(new double[]{15, 0.8}, new double[]{13});
        set.addData(new double[]{20, 0.8}, new double[]{17});
        set.addData(new double[]{25, 0.8}, new double[]{22});
        set.addData(new double[]{30, 0.8}, new double[]{27});
        set.addData(new double[]{35, 0.8}, new double[]{32});
        set.addData(new double[]{40, 0.8}, new double[]{36});
        set.addData(new double[]{45, 0.8}, new double[]{41});
        set.addData(new double[]{50, 0.8}, new double[]{46});
        set.addData(new double[]{55, 0.8}, new double[]{50});
        set.addData(new double[]{60, 0.8}, new double[]{55});
        set.addData(new double[]{65, 0.8}, new double[]{60});
        set.addData(new double[]{70, 0.8}, new double[]{65});
        set.addData(new double[]{75, 0.8}, new double[]{69});
        set.addData(new double[]{80, 0.8}, new double[]{74});
        set.addData(new double[]{85, 0.8}, new double[]{79});
        set.addData(new double[]{90, 0.8}, new double[]{83});

        return set;
    }

}