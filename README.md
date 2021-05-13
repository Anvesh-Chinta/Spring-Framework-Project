Note that ClassPathXmlApplicationContext class is used here to create application context. There are several implementations of the ApplicationContext interface in Spring framework. In standalone applications, it is common to create an instance of ClassPathXmlApplicationContext or FileSystemXmlApplicationContext.

we need to pass the name of the XML configuration file while creating object of ClassPathXmlApplicationContext class. Just ensure that the XML file is in the class path. Then we can use this application context to get the bean using the id provided in the XML config file.
