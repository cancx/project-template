/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artivisi.pos.service.impl;

import com.artivisi.pos.dao.master.CabangDao;
import com.artivisi.pos.dao.master.KartuPembayaranDao;
import com.artivisi.pos.dao.master.KassaDao;
import com.artivisi.pos.dao.master.ProdukDao;
import com.artivisi.pos.dao.master.RunningNumberDao;
import com.artivisi.pos.dao.master.ShiftDao;
import com.artivisi.pos.dao.master.SystemPropertyDao;
import com.artivisi.pos.model.master.Cabang;
import com.artivisi.pos.model.master.KartuPembayaran;
import com.artivisi.pos.model.master.Kassa;
import com.artivisi.pos.model.master.Produk;
import com.artivisi.pos.model.master.RunningNumber;
import com.artivisi.pos.model.master.Shift;
import com.artivisi.pos.model.master.SystemProperty;
import com.artivisi.pos.model.master.constant.MasterRunningNumberEnum;
import com.artivisi.pos.model.master.constant.TransaksiRunningNumberEnum;
import com.artivisi.pos.service.MasterService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service("masterService")
@Transactional(readOnly=true)
public class MasterServiceImpl implements MasterService{

    @Autowired private ProdukDao produkDao;
    @Autowired private CabangDao cabangDao;
    @Autowired private KassaDao kassaDao;
    @Autowired private ShiftDao shiftDao;
    @Autowired private KartuPembayaranDao kartuPembayaranDao;
    @Autowired private RunningNumberDao runningNumberDao;
    @Autowired private SystemPropertyDao systemPropertyDao;

    @Transactional
    public void simpan(Produk p) {
        produkDao.simpan(p);
    }

    @Transactional
    public void hapus(Produk p) {
        produkDao.hapus(p);
    }

    public List<Produk> semuaProduk() {
        return produkDao.semua();
    }

    public Produk produkBerdasarId(String id) {
        return produkDao.cariBerdasarId(id);
    }

    @Transactional
    public void hapus(Cabang p) {
        cabangDao.hapus(p);
    }

    @Transactional
    public void simpan(Cabang p) {
        cabangDao.simpan(p);
    }

    public List<Cabang> semuaCabang() {
        return cabangDao.semua();
    }

    public Cabang cabangBerdasarId(String id) {
        return cabangDao.cariBerdasarId(id);
    }

    @Transactional
    public void hapus(Kassa k){
        kassaDao.hapus(k);
    }

    @Transactional
    public Boolean simpan(Kassa k){
        try{
            kassaDao.simpan(k);
            return Boolean.TRUE;
        } catch(Throwable t){
            return Boolean.FALSE;
        }
    }

    public List<Kassa> semuaKassa(){
        return kassaDao.semua();
    }

    public Kassa kassaBerdasarId(String id){
        return kassaDao.cariBerdasarId(id);
    }

    @Transactional
    public void hapus(Shift s){
        shiftDao.hapus(s);
    }

    @Transactional
    public void simpan(Shift s){
        shiftDao.simpan(s);
    }

    public List<Shift> semuaShift(){
        return shiftDao.semua();
    }

    public Shift shiftBerdasarId(String id){
        return shiftDao.cariBerdasarId(id);
    }

    public Shift shiftSekarang(){
        return shiftDao.shiftSekarang();
    }


    @Transactional
    public void hapus(KartuPembayaran k){
        kartuPembayaranDao.hapus(k);
    }

    @Transactional
    public void simpan(KartuPembayaran k){
        kartuPembayaranDao.simpan(k);
    }

    public List<KartuPembayaran> semuaKartuPembayaran(){
        return kartuPembayaranDao.semua();
    }

    public KartuPembayaran kartuPembayaranBerdasarId(String id){
        return kartuPembayaranDao.cariBerdasarId(id);
    }

    @Transactional
    public void simpan(SystemProperty p) {
        systemPropertyDao.simpan(p);
    }

    public List<SystemProperty> semuaSystemProperty() {
        return systemPropertyDao.semua();
    }

    public SystemProperty systemPropertyBerdasarId(String id) {
        return systemPropertyDao.cariBerdasarId(id);
    }

    @Transactional
    public void simpan(RunningNumber p) {
        runningNumberDao.simpan(p);
    }

    public List<RunningNumber> semuaRunningNumber() {
        return runningNumberDao.semua();
    }

    @Transactional
    public String ambilBerikutnya(MasterRunningNumberEnum id,String idCabang) {
        return runningNumberDao.ambilBerikutnya(id,idCabang);
    }

    @Transactional
    public String ambilBerikutnya(TransaksiRunningNumberEnum id, Date date, String idCabang) {
        return runningNumberDao.ambilBerikutnya(id, date, idCabang);
    }
    
    @Transactional
    public String ambilBerikutnya(TransaksiRunningNumberEnum id) {
        Date date = systemPropertyDao.tanggalKerja();
        SystemProperty cabang = systemPropertyDao.cariBerdasarId(SystemProperty.CABANG);
        return runningNumberDao.ambilBerikutnya(id, date, cabang.getVal());
    }

    @Transactional
    public Date tanggalKerja(){
        return systemPropertyDao.tanggalKerja();
    }

    public Date tanggalServer(){
        //TODO harusnya diambil dari 
        return new Date();
    }
}
