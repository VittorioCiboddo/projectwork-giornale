package com.example.project_work_giornale.service;

import com.example.project_work_giornale.dao.NotiziaDao;
import com.example.project_work_giornale.model.Categoria;
import com.example.project_work_giornale.model.Notizia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NotiziaServiceImpl implements NotiziaService{

    @Autowired
    private NotiziaDao notiziaDao;

    @Override
    public List<Notizia> elencoNotizia() {
        return (List<Notizia>)
        notiziaDao.findAll();
    }

    @Override
    public Notizia dettaglioNotizia(int idNotizia) {
        Optional<Notizia> notiziaOptional = notiziaDao.findById(idNotizia);
        if(notiziaOptional.isPresent())
            return notiziaOptional.get();
        return null;
    }

    @Override
    public void aggiungiNotizia(Notizia notizia, String titolo, String descrizione, LocalDate dataPubblicazione, String immagine, String linkVideo, Categoria categoria) {
        notizia.setTitolo(titolo);
        notizia.setDescrizione(descrizione);
        notizia.setCategoria(categoria);
        notizia.setDataPubblicazione(dataPubblicazione);
        notizia.setLinkVideo(linkVideo);
    }

    @Override
    public void eliminaNotizia(int idNotizia) {
        notiziaDao.deleteById(idNotizia);
    }
}
