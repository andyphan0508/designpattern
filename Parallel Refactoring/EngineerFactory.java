public class EngineerFactory {

    public static Engineer getEngineer(Class class) throws InstantiationException, IllegalAccessException
    {
        return (Engineer) class.newInstance();
    }
}