package com.brq.interacoes;

import com.brq.interfaces.web.IArrastar;
import com.brq.interfaces.web.IClique;
import com.brq.interfaces.web.ICliqueJS;
import com.brq.interfaces.web.ICombo;
import com.brq.interfaces.web.IDesambiguador;
import com.brq.interfaces.web.IEscrever;
import com.brq.interfaces.web.IEscreverJS;
import com.brq.interfaces.web.IEsperaWeb;
import com.brq.interfaces.web.IFrame;
import com.brq.interfaces.web.ILimpar;
import com.brq.interfaces.web.IMover;
import com.brq.interfaces.web.IMoverJS;
import com.brq.interfaces.web.IObter;
import com.brq.interfaces.web.IObterJS;
import com.brq.interfaces.web.IRolarJS;
import com.brq.interfaces.web.IUtils;
import com.brq.interfaces.web.IValidacoesWeb;

public interface InteracaoWeb
		extends IArrastar, IClique, ICliqueJS, ICombo, IEscrever, IEscreverJS, IDesambiguador,
		IEsperaWeb, IFrame, ILimpar, IMover, IMoverJS, IObter, IObterJS, IRolarJS, IValidacoesWeb, IUtils {
}