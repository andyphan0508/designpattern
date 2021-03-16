public class Manager {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Engineer comp = EngineerFactory.getEngineer(PartialComputerEngineer.class);
        comp.setType("Computer Engineer");
        comp.setSalary(50000);

        Engineer civil = EngineerFactory.getEngineer(PartialCivilEngineer.class);
        civil.setType("Computer Engineer");
        civil.setSalary(50000);

        System.out.println(comp);
        System.out.println("********************");
        System.out.println(civil);
    }
}