package com.example.crm_project.Repository;


public interface RepositoryExampleWithNotes {
    /*
     * En la carpeta de repository podemos crear un archivo repository para:
     * - Account
     * - Lead
     * - Opportunity
     * - SalesRep
     *
     *
     * Por lo que he leido, aqui es donde vamos a hacer las llamadas a la base de datos.
     * Se le añade el extends JpaRepository, el cual permite hacer las llamadas CRUD
     * (public interface RepositoryCsv extends JpaRepository<Account, Long>)
     *
     * Ejemplo de llamada:
     *      @Query("Select count(id) From Opportunity group by SalesRep")
     *      List<Object[]> findCountBySalesRep();
     * o
     *
     *      @Query("Select count(id) From Opportunity where status like "CLOSED_WON"")
     *      List<Object[]> findCountByStatus("CLOSED_WON");
     *
     * + informacion => https://www.educba.com/java-repository/ // https://www.geeksforgeeks.org/spring-boot-jparepository-with-example/
     *                                          EL SEGUNDO LINK ES MUY MUY BUENO!
     *
     *
     * He intentado aplicar las dependencies, pero peta, creo que hay que empezar a meter cositas de la base de datos
     * en el applications.properties. Espero que nos lo enseñen, pero el link de geeksforgeeks enseña como conectar
     * a una database.
     * */

}
