package com.emergentes.dao;

import com.emergentes.modelo.Participantes;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParticipantesDAOimpl extends ConexionBD implements ParticipantesDAO {

    @Override
    public void insert(Participantes participante) throws Exception {
        String sql = "INSERT INTO participantes (nombres, apellidos, id_sem, confirmado) VALUES (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, participante.getNombres());
        ps.setString(2, participante.getApellidos());
        ps.setInt(3, participante.getIdSeminario());
        ps.setInt(4, participante.getConfirmado());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Participantes participante) throws Exception {
        String sql = "UPDATE participantes SET nombres=?, apellidos=?, id_sem=?, confirmado=? WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, participante.getNombres());
        ps.setString(2, participante.getApellidos());
        ps.setInt(3, participante.getIdSeminario());
        ps.setInt(4, participante.getConfirmado());
        ps.setInt(5, participante.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM participantes WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Participantes getById(int id) throws Exception {
        Participantes participante = new Participantes();
        String sql = "SELECT * FROM participantes WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            participante.setId(rs.getInt("id"));
            participante.setNombres(rs.getString("nombres"));
            participante.setApellidos(rs.getString("apellidos"));
            participante.setIdSeminario(rs.getInt("id_sem"));
            participante.setConfirmado(rs.getInt("confirmado"));
        }
        this.desconectar();
        return participante;
    }

    @Override
    public List<Participantes> getAll() throws Exception {
        List<Participantes> lista = null;
        String sql = "SELECT t1.*, t2.titulo FROM participantes t1 INNER JOIN seminarios t2 ON t1.id_sem=t2.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Participantes>();
        while (rs.next()) {            
            Participantes participante = new Participantes();
            participante.setId(rs.getInt("id"));
            participante.setNombres(rs.getString("nombres"));
            participante.setApellidos(rs.getString("apellidos"));
            participante.setIdSeminario(rs.getInt("id_sem"));
            participante.setConfirmado(rs.getInt("confirmado"));
            participante.setTituloSeminario(rs.getString("id_tit"));
            lista.add(participante);
        }
        this.desconectar();
        return lista;
    }

  
}
