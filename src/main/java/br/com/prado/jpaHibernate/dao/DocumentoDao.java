package br.com.prado.jpaHibernate.dao;

import br.com.prado.jpaHibernate.entity.Documento;

public class DocumentoDao extends GenericDao<Documento>{

	public DocumentoDao() {
		super(Documento.class);
	}

}
