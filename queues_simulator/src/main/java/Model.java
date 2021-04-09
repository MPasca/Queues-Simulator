public class Model {
    private Store newStore = new Store();

    public Model(Store store){
        this.newStore = store;
        store.printStoreComp();
    }

    public Model(){}
}
