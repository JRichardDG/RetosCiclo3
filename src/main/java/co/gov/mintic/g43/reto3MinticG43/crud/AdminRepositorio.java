/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package co.gov.mintic.g43.reto3MinticG43.crud;

import co.gov.mintic.g43.reto3MinticG43.entidades.Admin;
import co.gov.mintic.g43.reto3MinticG43.entidades.Score;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepositorio extends CrudRepository<Admin, Long> {
    public Admin findAllById(Long id);

    @Query("SELECT u FROM Admin u")
    public List<Admin> buscarusuarios();
}
