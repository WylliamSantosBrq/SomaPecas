package com.brq.interacoes;

import com.brq.interfaces.web.IAcoesBrowser;
import com.brq.interfaces.web.IAlert;
import com.brq.interfaces.web.IEsperaBrowser;
import com.brq.interfaces.web.IPrint;
import com.brq.interfaces.web.IValidacoesBrowser;

public interface InteracaoNavegador extends IAcoesBrowser, IAlert, IEsperaBrowser, IPrint, IValidacoesBrowser {

}
