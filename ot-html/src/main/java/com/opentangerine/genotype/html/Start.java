package com.opentangerine.genotype.html;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
class Start implements Gen {
    private String name;

    public Start() {
        this(null);
    }

    public Start(String name) {
        this.name = name;
    }

    @Override
    public Gen attr(String key) {
        return new Element(this.name).attr(key);
    }

    @Override
    public Gen attr(String key, String value) {
        return new Element(this.name).attr(key, value);
    }

    @Override
    public Gen attr(String key, Optional<String> value) {
        return new Element(this.name).attr(key, value);
    }

    @Override
    public Gen in(Renderable... tags) {
        return new Element(this.name).in(tags);
    }

    @Override
    public Gen in(String content) {
        return new Element(this.name).in(content);
    }

    @Override
    public Gen in(Stream<Renderable> stream) {
        return new Element(this.name).in(stream);
    }

    @Override
    public Gen accept(String accept) {
        return new Element(this.name).accept(accept);
    }
    @Override
    public Gen accept(Optional<String> accept) {
        return new Element(this.name).accept(accept);
    }
    @Override
    public Gen accept_charset(String accept_charset) {
        return new Element(this.name).accept_charset(accept_charset);
    }
    @Override
    public Gen accept_charset(Optional<String> accept_charset) {
        return new Element(this.name).accept_charset(accept_charset);
    }
    @Override
    public Gen accesskey(String accesskey) {
        return new Element(this.name).accesskey(accesskey);
    }
    @Override
    public Gen accesskey(Optional<String> accesskey) {
        return new Element(this.name).accesskey(accesskey);
    }
    @Override
    public Gen action(String action) {
        return new Element(this.name).action(action);
    }
    @Override
    public Gen action(Optional<String> action) {
        return new Element(this.name).action(action);
    }
    @Override
    public Gen align(String align) {
        return new Element(this.name).align(align);
    }
    @Override
    public Gen align(Optional<String> align) {
        return new Element(this.name).align(align);
    }
    @Override
    public Gen alt(String alt) {
        return new Element(this.name).alt(alt);
    }
    @Override
    public Gen alt(Optional<String> alt) {
        return new Element(this.name).alt(alt);
    }
    @Override
    public Gen async(String async) {
        return new Element(this.name).async(async);
    }
    @Override
    public Gen async(Optional<String> async) {
        return new Element(this.name).async(async);
    }
    @Override
    public Gen autocomplete(String autocomplete) {
        return new Element(this.name).autocomplete(autocomplete);
    }
    @Override
    public Gen autocomplete(Optional<String> autocomplete) {
        return new Element(this.name).autocomplete(autocomplete);
    }
    @Override
    public Gen autofocus(String autofocus) {
        return new Element(this.name).autofocus(autofocus);
    }
    @Override
    public Gen autofocus(Optional<String> autofocus) {
        return new Element(this.name).autofocus(autofocus);
    }
    @Override
    public Gen autoplay(String autoplay) {
        return new Element(this.name).autoplay(autoplay);
    }
    @Override
    public Gen autoplay(Optional<String> autoplay) {
        return new Element(this.name).autoplay(autoplay);
    }
    @Override
    public Gen bgcolor(String bgcolor) {
        return new Element(this.name).bgcolor(bgcolor);
    }
    @Override
    public Gen bgcolor(Optional<String> bgcolor) {
        return new Element(this.name).bgcolor(bgcolor);
    }
    @Override
    public Gen border(String border) {
        return new Element(this.name).border(border);
    }
    @Override
    public Gen border(Optional<String> border) {
        return new Element(this.name).border(border);
    }
    @Override
    public Gen challenge(String challenge) {
        return new Element(this.name).challenge(challenge);
    }
    @Override
    public Gen challenge(Optional<String> challenge) {
        return new Element(this.name).challenge(challenge);
    }
    @Override
    public Gen charset(String charset) {
        return new Element(this.name).charset(charset);
    }
    @Override
    public Gen charset(Optional<String> charset) {
        return new Element(this.name).charset(charset);
    }
    @Override
    public Gen checked(String checked) {
        return new Element(this.name).checked(checked);
    }
    @Override
    public Gen checked(Optional<String> checked) {
        return new Element(this.name).checked(checked);
    }
    @Override
    public Gen cite(String cite) {
        return new Element(this.name).cite(cite);
    }
    @Override
    public Gen cite(Optional<String> cite) {
        return new Element(this.name).cite(cite);
    }
    @Override
    public Gen classAttr(String classAttr) {
        return new Element(this.name).classAttr(classAttr);
    }
    @Override
    public Gen classAttr(Optional<String> classAttr) {
        return new Element(this.name).classAttr(classAttr);
    }
    @Override
    public Gen color(String color) {
        return new Element(this.name).color(color);
    }
    @Override
    public Gen color(Optional<String> color) {
        return new Element(this.name).color(color);
    }
    @Override
    public Gen cols(String cols) {
        return new Element(this.name).cols(cols);
    }
    @Override
    public Gen cols(Optional<String> cols) {
        return new Element(this.name).cols(cols);
    }
    @Override
    public Gen colspan(String colspan) {
        return new Element(this.name).colspan(colspan);
    }
    @Override
    public Gen colspan(Optional<String> colspan) {
        return new Element(this.name).colspan(colspan);
    }
    @Override
    public Gen content(String content) {
        return new Element(this.name).content(content);
    }
    @Override
    public Gen content(Optional<String> content) {
        return new Element(this.name).content(content);
    }
    @Override
    public Gen contenteditable(String contenteditable) {
        return new Element(this.name).contenteditable(contenteditable);
    }
    @Override
    public Gen contenteditable(Optional<String> contenteditable) {
        return new Element(this.name).contenteditable(contenteditable);
    }
    @Override
    public Gen contextmenu(String contextmenu) {
        return new Element(this.name).contextmenu(contextmenu);
    }
    @Override
    public Gen contextmenu(Optional<String> contextmenu) {
        return new Element(this.name).contextmenu(contextmenu);
    }
    @Override
    public Gen controls(String controls) {
        return new Element(this.name).controls(controls);
    }
    @Override
    public Gen controls(Optional<String> controls) {
        return new Element(this.name).controls(controls);
    }
    @Override
    public Gen coords(String coords) {
        return new Element(this.name).coords(coords);
    }
    @Override
    public Gen coords(Optional<String> coords) {
        return new Element(this.name).coords(coords);
    }
    @Override
    public Gen data(String data) {
        return new Element(this.name).data(data);
    }
    @Override
    public Gen data(Optional<String> data) {
        return new Element(this.name).data(data);
    }
    @Override
    public Gen datetime(String datetime) {
        return new Element(this.name).datetime(datetime);
    }
    @Override
    public Gen datetime(Optional<String> datetime) {
        return new Element(this.name).datetime(datetime);
    }
    @Override
    public Gen defaultAttr(String defaultAttr) {
        return new Element(this.name).defaultAttr(defaultAttr);
    }
    @Override
    public Gen defaultAttr(Optional<String> defaultAttr) {
        return new Element(this.name).defaultAttr(defaultAttr);
    }
    @Override
    public Gen defer(String defer) {
        return new Element(this.name).defer(defer);
    }
    @Override
    public Gen defer(Optional<String> defer) {
        return new Element(this.name).defer(defer);
    }
    @Override
    public Gen dir(String dir) {
        return new Element(this.name).dir(dir);
    }
    @Override
    public Gen dir(Optional<String> dir) {
        return new Element(this.name).dir(dir);
    }
    @Override
    public Gen dirname(String dirname) {
        return new Element(this.name).dirname(dirname);
    }
    @Override
    public Gen dirname(Optional<String> dirname) {
        return new Element(this.name).dirname(dirname);
    }
    @Override
    public Gen disabled(String disabled) {
        return new Element(this.name).disabled(disabled);
    }
    @Override
    public Gen disabled(Optional<String> disabled) {
        return new Element(this.name).disabled(disabled);
    }
    @Override
    public Gen download(String download) {
        return new Element(this.name).download(download);
    }
    @Override
    public Gen download(Optional<String> download) {
        return new Element(this.name).download(download);
    }
    @Override
    public Gen draggable(String draggable) {
        return new Element(this.name).draggable(draggable);
    }
    @Override
    public Gen draggable(Optional<String> draggable) {
        return new Element(this.name).draggable(draggable);
    }
    @Override
    public Gen dropzone(String dropzone) {
        return new Element(this.name).dropzone(dropzone);
    }
    @Override
    public Gen dropzone(Optional<String> dropzone) {
        return new Element(this.name).dropzone(dropzone);
    }
    @Override
    public Gen enctype(String enctype) {
        return new Element(this.name).enctype(enctype);
    }
    @Override
    public Gen enctype(Optional<String> enctype) {
        return new Element(this.name).enctype(enctype);
    }
    @Override
    public Gen forAttr(String forAttr) {
        return new Element(this.name).forAttr(forAttr);
    }
    @Override
    public Gen forAttr(Optional<String> forAttr) {
        return new Element(this.name).forAttr(forAttr);
    }
    @Override
    public Gen form(String form) {
        return new Element(this.name).form(form);
    }
    @Override
    public Gen form(Optional<String> form) {
        return new Element(this.name).form(form);
    }
    @Override
    public Gen formaction(String formaction) {
        return new Element(this.name).formaction(formaction);
    }
    @Override
    public Gen formaction(Optional<String> formaction) {
        return new Element(this.name).formaction(formaction);
    }
    @Override
    public Gen headers(String headers) {
        return new Element(this.name).headers(headers);
    }
    @Override
    public Gen headers(Optional<String> headers) {
        return new Element(this.name).headers(headers);
    }
    @Override
    public Gen height(String height) {
        return new Element(this.name).height(height);
    }
    @Override
    public Gen height(Optional<String> height) {
        return new Element(this.name).height(height);
    }
    @Override
    public Gen hidden(String hidden) {
        return new Element(this.name).hidden(hidden);
    }
    @Override
    public Gen hidden(Optional<String> hidden) {
        return new Element(this.name).hidden(hidden);
    }
    @Override
    public Gen high(String high) {
        return new Element(this.name).high(high);
    }
    @Override
    public Gen high(Optional<String> high) {
        return new Element(this.name).high(high);
    }
    @Override
    public Gen href(String href) {
        return new Element(this.name).href(href);
    }
    @Override
    public Gen href(Optional<String> href) {
        return new Element(this.name).href(href);
    }
    @Override
    public Gen hreflang(String hreflang) {
        return new Element(this.name).hreflang(hreflang);
    }
    @Override
    public Gen hreflang(Optional<String> hreflang) {
        return new Element(this.name).hreflang(hreflang);
    }
    @Override
    public Gen http_equiv(String http_equiv) {
        return new Element(this.name).http_equiv(http_equiv);
    }
    @Override
    public Gen http_equiv(Optional<String> http_equiv) {
        return new Element(this.name).http_equiv(http_equiv);
    }
    @Override
    public Gen id(String id) {
        return new Element(this.name).id(id);
    }
    @Override
    public Gen id(Optional<String> id) {
        return new Element(this.name).id(id);
    }
    @Override
    public Gen ismap(String ismap) {
        return new Element(this.name).ismap(ismap);
    }
    @Override
    public Gen ismap(Optional<String> ismap) {
        return new Element(this.name).ismap(ismap);
    }
    @Override
    public Gen keytype(String keytype) {
        return new Element(this.name).keytype(keytype);
    }
    @Override
    public Gen keytype(Optional<String> keytype) {
        return new Element(this.name).keytype(keytype);
    }
    @Override
    public Gen kind(String kind) {
        return new Element(this.name).kind(kind);
    }
    @Override
    public Gen kind(Optional<String> kind) {
        return new Element(this.name).kind(kind);
    }
    @Override
    public Gen label(String label) {
        return new Element(this.name).label(label);
    }
    @Override
    public Gen label(Optional<String> label) {
        return new Element(this.name).label(label);
    }
    @Override
    public Gen lang(String lang) {
        return new Element(this.name).lang(lang);
    }
    @Override
    public Gen lang(Optional<String> lang) {
        return new Element(this.name).lang(lang);
    }
    @Override
    public Gen list(String list) {
        return new Element(this.name).list(list);
    }
    @Override
    public Gen list(Optional<String> list) {
        return new Element(this.name).list(list);
    }
    @Override
    public Gen loop(String loop) {
        return new Element(this.name).loop(loop);
    }
    @Override
    public Gen loop(Optional<String> loop) {
        return new Element(this.name).loop(loop);
    }
    @Override
    public Gen low(String low) {
        return new Element(this.name).low(low);
    }
    @Override
    public Gen low(Optional<String> low) {
        return new Element(this.name).low(low);
    }
    @Override
    public Gen manifest(String manifest) {
        return new Element(this.name).manifest(manifest);
    }
    @Override
    public Gen manifest(Optional<String> manifest) {
        return new Element(this.name).manifest(manifest);
    }
    @Override
    public Gen max(String max) {
        return new Element(this.name).max(max);
    }
    @Override
    public Gen max(Optional<String> max) {
        return new Element(this.name).max(max);
    }
    @Override
    public Gen maxlength(String maxlength) {
        return new Element(this.name).maxlength(maxlength);
    }
    @Override
    public Gen maxlength(Optional<String> maxlength) {
        return new Element(this.name).maxlength(maxlength);
    }
    @Override
    public Gen media(String media) {
        return new Element(this.name).media(media);
    }
    @Override
    public Gen media(Optional<String> media) {
        return new Element(this.name).media(media);
    }
    @Override
    public Gen method(String method) {
        return new Element(this.name).method(method);
    }
    @Override
    public Gen method(Optional<String> method) {
        return new Element(this.name).method(method);
    }
    @Override
    public Gen min(String min) {
        return new Element(this.name).min(min);
    }
    @Override
    public Gen min(Optional<String> min) {
        return new Element(this.name).min(min);
    }
    @Override
    public Gen multiple(String multiple) {
        return new Element(this.name).multiple(multiple);
    }
    @Override
    public Gen multiple(Optional<String> multiple) {
        return new Element(this.name).multiple(multiple);
    }
    @Override
    public Gen muted(String muted) {
        return new Element(this.name).muted(muted);
    }
    @Override
    public Gen muted(Optional<String> muted) {
        return new Element(this.name).muted(muted);
    }
    @Override
    public Gen name(String name) {
        return new Element(this.name).name(name);
    }
    @Override
    public Gen name(Optional<String> name) {
        return new Element(this.name).name(name);
    }
    @Override
    public Gen novalidate(String novalidate) {
        return new Element(this.name).novalidate(novalidate);
    }
    @Override
    public Gen novalidate(Optional<String> novalidate) {
        return new Element(this.name).novalidate(novalidate);
    }
    @Override
    public Gen onabort(String onabort) {
        return new Element(this.name).onabort(onabort);
    }
    @Override
    public Gen onabort(Optional<String> onabort) {
        return new Element(this.name).onabort(onabort);
    }
    @Override
    public Gen onafterprint(String onafterprint) {
        return new Element(this.name).onafterprint(onafterprint);
    }
    @Override
    public Gen onafterprint(Optional<String> onafterprint) {
        return new Element(this.name).onafterprint(onafterprint);
    }
    @Override
    public Gen onbeforeprint(String onbeforeprint) {
        return new Element(this.name).onbeforeprint(onbeforeprint);
    }
    @Override
    public Gen onbeforeprint(Optional<String> onbeforeprint) {
        return new Element(this.name).onbeforeprint(onbeforeprint);
    }
    @Override
    public Gen onbeforeunload(String onbeforeunload) {
        return new Element(this.name).onbeforeunload(onbeforeunload);
    }
    @Override
    public Gen onbeforeunload(Optional<String> onbeforeunload) {
        return new Element(this.name).onbeforeunload(onbeforeunload);
    }
    @Override
    public Gen onblur(String onblur) {
        return new Element(this.name).onblur(onblur);
    }
    @Override
    public Gen onblur(Optional<String> onblur) {
        return new Element(this.name).onblur(onblur);
    }
    @Override
    public Gen oncanplay(String oncanplay) {
        return new Element(this.name).oncanplay(oncanplay);
    }
    @Override
    public Gen oncanplay(Optional<String> oncanplay) {
        return new Element(this.name).oncanplay(oncanplay);
    }
    @Override
    public Gen oncanplaythrough(String oncanplaythrough) {
        return new Element(this.name).oncanplaythrough(oncanplaythrough);
    }
    @Override
    public Gen oncanplaythrough(Optional<String> oncanplaythrough) {
        return new Element(this.name).oncanplaythrough(oncanplaythrough);
    }
    @Override
    public Gen onchange(String onchange) {
        return new Element(this.name).onchange(onchange);
    }
    @Override
    public Gen onchange(Optional<String> onchange) {
        return new Element(this.name).onchange(onchange);
    }
    @Override
    public Gen onclick(String onclick) {
        return new Element(this.name).onclick(onclick);
    }
    @Override
    public Gen onclick(Optional<String> onclick) {
        return new Element(this.name).onclick(onclick);
    }
    @Override
    public Gen oncontextmenu(String oncontextmenu) {
        return new Element(this.name).oncontextmenu(oncontextmenu);
    }
    @Override
    public Gen oncontextmenu(Optional<String> oncontextmenu) {
        return new Element(this.name).oncontextmenu(oncontextmenu);
    }
    @Override
    public Gen oncopy(String oncopy) {
        return new Element(this.name).oncopy(oncopy);
    }
    @Override
    public Gen oncopy(Optional<String> oncopy) {
        return new Element(this.name).oncopy(oncopy);
    }
    @Override
    public Gen oncuechange(String oncuechange) {
        return new Element(this.name).oncuechange(oncuechange);
    }
    @Override
    public Gen oncuechange(Optional<String> oncuechange) {
        return new Element(this.name).oncuechange(oncuechange);
    }
    @Override
    public Gen oncut(String oncut) {
        return new Element(this.name).oncut(oncut);
    }
    @Override
    public Gen oncut(Optional<String> oncut) {
        return new Element(this.name).oncut(oncut);
    }
    @Override
    public Gen ondblclick(String ondblclick) {
        return new Element(this.name).ondblclick(ondblclick);
    }
    @Override
    public Gen ondblclick(Optional<String> ondblclick) {
        return new Element(this.name).ondblclick(ondblclick);
    }
    @Override
    public Gen ondrag(String ondrag) {
        return new Element(this.name).ondrag(ondrag);
    }
    @Override
    public Gen ondrag(Optional<String> ondrag) {
        return new Element(this.name).ondrag(ondrag);
    }
    @Override
    public Gen ondragend(String ondragend) {
        return new Element(this.name).ondragend(ondragend);
    }
    @Override
    public Gen ondragend(Optional<String> ondragend) {
        return new Element(this.name).ondragend(ondragend);
    }
    @Override
    public Gen ondragenter(String ondragenter) {
        return new Element(this.name).ondragenter(ondragenter);
    }
    @Override
    public Gen ondragenter(Optional<String> ondragenter) {
        return new Element(this.name).ondragenter(ondragenter);
    }
    @Override
    public Gen ondragleave(String ondragleave) {
        return new Element(this.name).ondragleave(ondragleave);
    }
    @Override
    public Gen ondragleave(Optional<String> ondragleave) {
        return new Element(this.name).ondragleave(ondragleave);
    }
    @Override
    public Gen ondragover(String ondragover) {
        return new Element(this.name).ondragover(ondragover);
    }
    @Override
    public Gen ondragover(Optional<String> ondragover) {
        return new Element(this.name).ondragover(ondragover);
    }
    @Override
    public Gen ondragstart(String ondragstart) {
        return new Element(this.name).ondragstart(ondragstart);
    }
    @Override
    public Gen ondragstart(Optional<String> ondragstart) {
        return new Element(this.name).ondragstart(ondragstart);
    }
    @Override
    public Gen ondrop(String ondrop) {
        return new Element(this.name).ondrop(ondrop);
    }
    @Override
    public Gen ondrop(Optional<String> ondrop) {
        return new Element(this.name).ondrop(ondrop);
    }
    @Override
    public Gen ondurationchange(String ondurationchange) {
        return new Element(this.name).ondurationchange(ondurationchange);
    }
    @Override
    public Gen ondurationchange(Optional<String> ondurationchange) {
        return new Element(this.name).ondurationchange(ondurationchange);
    }
    @Override
    public Gen onemptied(String onemptied) {
        return new Element(this.name).onemptied(onemptied);
    }
    @Override
    public Gen onemptied(Optional<String> onemptied) {
        return new Element(this.name).onemptied(onemptied);
    }
    @Override
    public Gen onended(String onended) {
        return new Element(this.name).onended(onended);
    }
    @Override
    public Gen onended(Optional<String> onended) {
        return new Element(this.name).onended(onended);
    }
    @Override
    public Gen onerror(String onerror) {
        return new Element(this.name).onerror(onerror);
    }
    @Override
    public Gen onerror(Optional<String> onerror) {
        return new Element(this.name).onerror(onerror);
    }
    @Override
    public Gen onfocus(String onfocus) {
        return new Element(this.name).onfocus(onfocus);
    }
    @Override
    public Gen onfocus(Optional<String> onfocus) {
        return new Element(this.name).onfocus(onfocus);
    }
    @Override
    public Gen onhashchange(String onhashchange) {
        return new Element(this.name).onhashchange(onhashchange);
    }
    @Override
    public Gen onhashchange(Optional<String> onhashchange) {
        return new Element(this.name).onhashchange(onhashchange);
    }
    @Override
    public Gen oninput(String oninput) {
        return new Element(this.name).oninput(oninput);
    }
    @Override
    public Gen oninput(Optional<String> oninput) {
        return new Element(this.name).oninput(oninput);
    }
    @Override
    public Gen oninvalid(String oninvalid) {
        return new Element(this.name).oninvalid(oninvalid);
    }
    @Override
    public Gen oninvalid(Optional<String> oninvalid) {
        return new Element(this.name).oninvalid(oninvalid);
    }
    @Override
    public Gen onkeydown(String onkeydown) {
        return new Element(this.name).onkeydown(onkeydown);
    }
    @Override
    public Gen onkeydown(Optional<String> onkeydown) {
        return new Element(this.name).onkeydown(onkeydown);
    }
    @Override
    public Gen onkeypress(String onkeypress) {
        return new Element(this.name).onkeypress(onkeypress);
    }
    @Override
    public Gen onkeypress(Optional<String> onkeypress) {
        return new Element(this.name).onkeypress(onkeypress);
    }
    @Override
    public Gen onkeyup(String onkeyup) {
        return new Element(this.name).onkeyup(onkeyup);
    }
    @Override
    public Gen onkeyup(Optional<String> onkeyup) {
        return new Element(this.name).onkeyup(onkeyup);
    }
    @Override
    public Gen onload(String onload) {
        return new Element(this.name).onload(onload);
    }
    @Override
    public Gen onload(Optional<String> onload) {
        return new Element(this.name).onload(onload);
    }
    @Override
    public Gen onloadeddata(String onloadeddata) {
        return new Element(this.name).onloadeddata(onloadeddata);
    }
    @Override
    public Gen onloadeddata(Optional<String> onloadeddata) {
        return new Element(this.name).onloadeddata(onloadeddata);
    }
    @Override
    public Gen onloadedmetadata(String onloadedmetadata) {
        return new Element(this.name).onloadedmetadata(onloadedmetadata);
    }
    @Override
    public Gen onloadedmetadata(Optional<String> onloadedmetadata) {
        return new Element(this.name).onloadedmetadata(onloadedmetadata);
    }
    @Override
    public Gen onloadstart(String onloadstart) {
        return new Element(this.name).onloadstart(onloadstart);
    }
    @Override
    public Gen onloadstart(Optional<String> onloadstart) {
        return new Element(this.name).onloadstart(onloadstart);
    }
    @Override
    public Gen onmousedown(String onmousedown) {
        return new Element(this.name).onmousedown(onmousedown);
    }
    @Override
    public Gen onmousedown(Optional<String> onmousedown) {
        return new Element(this.name).onmousedown(onmousedown);
    }
    @Override
    public Gen onmousemove(String onmousemove) {
        return new Element(this.name).onmousemove(onmousemove);
    }
    @Override
    public Gen onmousemove(Optional<String> onmousemove) {
        return new Element(this.name).onmousemove(onmousemove);
    }
    @Override
    public Gen onmouseout(String onmouseout) {
        return new Element(this.name).onmouseout(onmouseout);
    }
    @Override
    public Gen onmouseout(Optional<String> onmouseout) {
        return new Element(this.name).onmouseout(onmouseout);
    }
    @Override
    public Gen onmouseover(String onmouseover) {
        return new Element(this.name).onmouseover(onmouseover);
    }
    @Override
    public Gen onmouseover(Optional<String> onmouseover) {
        return new Element(this.name).onmouseover(onmouseover);
    }
    @Override
    public Gen onmouseup(String onmouseup) {
        return new Element(this.name).onmouseup(onmouseup);
    }
    @Override
    public Gen onmouseup(Optional<String> onmouseup) {
        return new Element(this.name).onmouseup(onmouseup);
    }
    @Override
    public Gen onmousewheel(String onmousewheel) {
        return new Element(this.name).onmousewheel(onmousewheel);
    }
    @Override
    public Gen onmousewheel(Optional<String> onmousewheel) {
        return new Element(this.name).onmousewheel(onmousewheel);
    }
    @Override
    public Gen onoffline(String onoffline) {
        return new Element(this.name).onoffline(onoffline);
    }
    @Override
    public Gen onoffline(Optional<String> onoffline) {
        return new Element(this.name).onoffline(onoffline);
    }
    @Override
    public Gen ononline(String ononline) {
        return new Element(this.name).ononline(ononline);
    }
    @Override
    public Gen ononline(Optional<String> ononline) {
        return new Element(this.name).ononline(ononline);
    }
    @Override
    public Gen onpagehide(String onpagehide) {
        return new Element(this.name).onpagehide(onpagehide);
    }
    @Override
    public Gen onpagehide(Optional<String> onpagehide) {
        return new Element(this.name).onpagehide(onpagehide);
    }
    @Override
    public Gen onpageshow(String onpageshow) {
        return new Element(this.name).onpageshow(onpageshow);
    }
    @Override
    public Gen onpageshow(Optional<String> onpageshow) {
        return new Element(this.name).onpageshow(onpageshow);
    }
    @Override
    public Gen onpaste(String onpaste) {
        return new Element(this.name).onpaste(onpaste);
    }
    @Override
    public Gen onpaste(Optional<String> onpaste) {
        return new Element(this.name).onpaste(onpaste);
    }
    @Override
    public Gen onpause(String onpause) {
        return new Element(this.name).onpause(onpause);
    }
    @Override
    public Gen onpause(Optional<String> onpause) {
        return new Element(this.name).onpause(onpause);
    }
    @Override
    public Gen onplay(String onplay) {
        return new Element(this.name).onplay(onplay);
    }
    @Override
    public Gen onplay(Optional<String> onplay) {
        return new Element(this.name).onplay(onplay);
    }
    @Override
    public Gen onplaying(String onplaying) {
        return new Element(this.name).onplaying(onplaying);
    }
    @Override
    public Gen onplaying(Optional<String> onplaying) {
        return new Element(this.name).onplaying(onplaying);
    }
    @Override
    public Gen onpopstate(String onpopstate) {
        return new Element(this.name).onpopstate(onpopstate);
    }
    @Override
    public Gen onpopstate(Optional<String> onpopstate) {
        return new Element(this.name).onpopstate(onpopstate);
    }
    @Override
    public Gen onprogress(String onprogress) {
        return new Element(this.name).onprogress(onprogress);
    }
    @Override
    public Gen onprogress(Optional<String> onprogress) {
        return new Element(this.name).onprogress(onprogress);
    }
    @Override
    public Gen onratechange(String onratechange) {
        return new Element(this.name).onratechange(onratechange);
    }
    @Override
    public Gen onratechange(Optional<String> onratechange) {
        return new Element(this.name).onratechange(onratechange);
    }
    @Override
    public Gen onreset(String onreset) {
        return new Element(this.name).onreset(onreset);
    }
    @Override
    public Gen onreset(Optional<String> onreset) {
        return new Element(this.name).onreset(onreset);
    }
    @Override
    public Gen onresize(String onresize) {
        return new Element(this.name).onresize(onresize);
    }
    @Override
    public Gen onresize(Optional<String> onresize) {
        return new Element(this.name).onresize(onresize);
    }
    @Override
    public Gen onscroll(String onscroll) {
        return new Element(this.name).onscroll(onscroll);
    }
    @Override
    public Gen onscroll(Optional<String> onscroll) {
        return new Element(this.name).onscroll(onscroll);
    }
    @Override
    public Gen onsearch(String onsearch) {
        return new Element(this.name).onsearch(onsearch);
    }
    @Override
    public Gen onsearch(Optional<String> onsearch) {
        return new Element(this.name).onsearch(onsearch);
    }
    @Override
    public Gen onseeked(String onseeked) {
        return new Element(this.name).onseeked(onseeked);
    }
    @Override
    public Gen onseeked(Optional<String> onseeked) {
        return new Element(this.name).onseeked(onseeked);
    }
    @Override
    public Gen onseeking(String onseeking) {
        return new Element(this.name).onseeking(onseeking);
    }
    @Override
    public Gen onseeking(Optional<String> onseeking) {
        return new Element(this.name).onseeking(onseeking);
    }
    @Override
    public Gen onselect(String onselect) {
        return new Element(this.name).onselect(onselect);
    }
    @Override
    public Gen onselect(Optional<String> onselect) {
        return new Element(this.name).onselect(onselect);
    }
    @Override
    public Gen onshow(String onshow) {
        return new Element(this.name).onshow(onshow);
    }
    @Override
    public Gen onshow(Optional<String> onshow) {
        return new Element(this.name).onshow(onshow);
    }
    @Override
    public Gen onstalled(String onstalled) {
        return new Element(this.name).onstalled(onstalled);
    }
    @Override
    public Gen onstalled(Optional<String> onstalled) {
        return new Element(this.name).onstalled(onstalled);
    }
    @Override
    public Gen onstorage(String onstorage) {
        return new Element(this.name).onstorage(onstorage);
    }
    @Override
    public Gen onstorage(Optional<String> onstorage) {
        return new Element(this.name).onstorage(onstorage);
    }
    @Override
    public Gen onsubmit(String onsubmit) {
        return new Element(this.name).onsubmit(onsubmit);
    }
    @Override
    public Gen onsubmit(Optional<String> onsubmit) {
        return new Element(this.name).onsubmit(onsubmit);
    }
    @Override
    public Gen onsuspend(String onsuspend) {
        return new Element(this.name).onsuspend(onsuspend);
    }
    @Override
    public Gen onsuspend(Optional<String> onsuspend) {
        return new Element(this.name).onsuspend(onsuspend);
    }
    @Override
    public Gen ontimeupdate(String ontimeupdate) {
        return new Element(this.name).ontimeupdate(ontimeupdate);
    }
    @Override
    public Gen ontimeupdate(Optional<String> ontimeupdate) {
        return new Element(this.name).ontimeupdate(ontimeupdate);
    }
    @Override
    public Gen ontoggle(String ontoggle) {
        return new Element(this.name).ontoggle(ontoggle);
    }
    @Override
    public Gen ontoggle(Optional<String> ontoggle) {
        return new Element(this.name).ontoggle(ontoggle);
    }
    @Override
    public Gen onunload(String onunload) {
        return new Element(this.name).onunload(onunload);
    }
    @Override
    public Gen onunload(Optional<String> onunload) {
        return new Element(this.name).onunload(onunload);
    }
    @Override
    public Gen onvolumechange(String onvolumechange) {
        return new Element(this.name).onvolumechange(onvolumechange);
    }
    @Override
    public Gen onvolumechange(Optional<String> onvolumechange) {
        return new Element(this.name).onvolumechange(onvolumechange);
    }
    @Override
    public Gen onwaiting(String onwaiting) {
        return new Element(this.name).onwaiting(onwaiting);
    }
    @Override
    public Gen onwaiting(Optional<String> onwaiting) {
        return new Element(this.name).onwaiting(onwaiting);
    }
    @Override
    public Gen onwheel(String onwheel) {
        return new Element(this.name).onwheel(onwheel);
    }
    @Override
    public Gen onwheel(Optional<String> onwheel) {
        return new Element(this.name).onwheel(onwheel);
    }
    @Override
    public Gen open(String open) {
        return new Element(this.name).open(open);
    }
    @Override
    public Gen open(Optional<String> open) {
        return new Element(this.name).open(open);
    }
    @Override
    public Gen optimum(String optimum) {
        return new Element(this.name).optimum(optimum);
    }
    @Override
    public Gen optimum(Optional<String> optimum) {
        return new Element(this.name).optimum(optimum);
    }
    @Override
    public Gen pattern(String pattern) {
        return new Element(this.name).pattern(pattern);
    }
    @Override
    public Gen pattern(Optional<String> pattern) {
        return new Element(this.name).pattern(pattern);
    }
    @Override
    public Gen placeholder(String placeholder) {
        return new Element(this.name).placeholder(placeholder);
    }
    @Override
    public Gen placeholder(Optional<String> placeholder) {
        return new Element(this.name).placeholder(placeholder);
    }
    @Override
    public Gen poster(String poster) {
        return new Element(this.name).poster(poster);
    }
    @Override
    public Gen poster(Optional<String> poster) {
        return new Element(this.name).poster(poster);
    }
    @Override
    public Gen preload(String preload) {
        return new Element(this.name).preload(preload);
    }
    @Override
    public Gen preload(Optional<String> preload) {
        return new Element(this.name).preload(preload);
    }
    @Override
    public Gen readonly(String readonly) {
        return new Element(this.name).readonly(readonly);
    }
    @Override
    public Gen readonly(Optional<String> readonly) {
        return new Element(this.name).readonly(readonly);
    }
    @Override
    public Gen rel(String rel) {
        return new Element(this.name).rel(rel);
    }
    @Override
    public Gen rel(Optional<String> rel) {
        return new Element(this.name).rel(rel);
    }
    @Override
    public Gen required(String required) {
        return new Element(this.name).required(required);
    }
    @Override
    public Gen required(Optional<String> required) {
        return new Element(this.name).required(required);
    }
    @Override
    public Gen reversed(String reversed) {
        return new Element(this.name).reversed(reversed);
    }
    @Override
    public Gen reversed(Optional<String> reversed) {
        return new Element(this.name).reversed(reversed);
    }
    @Override
    public Gen rows(String rows) {
        return new Element(this.name).rows(rows);
    }
    @Override
    public Gen rows(Optional<String> rows) {
        return new Element(this.name).rows(rows);
    }
    @Override
    public Gen rowspan(String rowspan) {
        return new Element(this.name).rowspan(rowspan);
    }
    @Override
    public Gen rowspan(Optional<String> rowspan) {
        return new Element(this.name).rowspan(rowspan);
    }
    @Override
    public Gen sandbox(String sandbox) {
        return new Element(this.name).sandbox(sandbox);
    }
    @Override
    public Gen sandbox(Optional<String> sandbox) {
        return new Element(this.name).sandbox(sandbox);
    }
    @Override
    public Gen scope(String scope) {
        return new Element(this.name).scope(scope);
    }
    @Override
    public Gen scope(Optional<String> scope) {
        return new Element(this.name).scope(scope);
    }
    @Override
    public Gen scoped(String scoped) {
        return new Element(this.name).scoped(scoped);
    }
    @Override
    public Gen scoped(Optional<String> scoped) {
        return new Element(this.name).scoped(scoped);
    }
    @Override
    public Gen selected(String selected) {
        return new Element(this.name).selected(selected);
    }
    @Override
    public Gen selected(Optional<String> selected) {
        return new Element(this.name).selected(selected);
    }
    @Override
    public Gen shape(String shape) {
        return new Element(this.name).shape(shape);
    }
    @Override
    public Gen shape(Optional<String> shape) {
        return new Element(this.name).shape(shape);
    }
    @Override
    public Gen size(String size) {
        return new Element(this.name).size(size);
    }
    @Override
    public Gen size(Optional<String> size) {
        return new Element(this.name).size(size);
    }
    @Override
    public Gen sizes(String sizes) {
        return new Element(this.name).sizes(sizes);
    }
    @Override
    public Gen sizes(Optional<String> sizes) {
        return new Element(this.name).sizes(sizes);
    }
    @Override
    public Gen span(String span) {
        return new Element(this.name).span(span);
    }
    @Override
    public Gen span(Optional<String> span) {
        return new Element(this.name).span(span);
    }
    @Override
    public Gen spellcheck(String spellcheck) {
        return new Element(this.name).spellcheck(spellcheck);
    }
    @Override
    public Gen spellcheck(Optional<String> spellcheck) {
        return new Element(this.name).spellcheck(spellcheck);
    }
    @Override
    public Gen src(String src) {
        return new Element(this.name).src(src);
    }
    @Override
    public Gen src(Optional<String> src) {
        return new Element(this.name).src(src);
    }
    @Override
    public Gen srcdoc(String srcdoc) {
        return new Element(this.name).srcdoc(srcdoc);
    }
    @Override
    public Gen srcdoc(Optional<String> srcdoc) {
        return new Element(this.name).srcdoc(srcdoc);
    }
    @Override
    public Gen srclang(String srclang) {
        return new Element(this.name).srclang(srclang);
    }
    @Override
    public Gen srclang(Optional<String> srclang) {
        return new Element(this.name).srclang(srclang);
    }
    @Override
    public Gen start(String start) {
        return new Element(this.name).start(start);
    }
    @Override
    public Gen start(Optional<String> start) {
        return new Element(this.name).start(start);
    }
    @Override
    public Gen step(String step) {
        return new Element(this.name).step(step);
    }
    @Override
    public Gen step(Optional<String> step) {
        return new Element(this.name).step(step);
    }
    @Override
    public Gen style(String style) {
        return new Element(this.name).style(style);
    }
    @Override
    public Gen style(Optional<String> style) {
        return new Element(this.name).style(style);
    }
    @Override
    public Gen tabindex(String tabindex) {
        return new Element(this.name).tabindex(tabindex);
    }
    @Override
    public Gen tabindex(Optional<String> tabindex) {
        return new Element(this.name).tabindex(tabindex);
    }
    @Override
    public Gen target(String target) {
        return new Element(this.name).target(target);
    }
    @Override
    public Gen target(Optional<String> target) {
        return new Element(this.name).target(target);
    }
    @Override
    public Gen title(String title) {
        return new Element(this.name).title(title);
    }
    @Override
    public Gen title(Optional<String> title) {
        return new Element(this.name).title(title);
    }
    @Override
    public Gen translate(String translate) {
        return new Element(this.name).translate(translate);
    }
    @Override
    public Gen translate(Optional<String> translate) {
        return new Element(this.name).translate(translate);
    }
    @Override
    public Gen type(String type) {
        return new Element(this.name).type(type);
    }
    @Override
    public Gen type(Optional<String> type) {
        return new Element(this.name).type(type);
    }
    @Override
    public Gen usemap(String usemap) {
        return new Element(this.name).usemap(usemap);
    }
    @Override
    public Gen usemap(Optional<String> usemap) {
        return new Element(this.name).usemap(usemap);
    }
    @Override
    public Gen value(String value) {
        return new Element(this.name).value(value);
    }
    @Override
    public Gen value(Optional<String> value) {
        return new Element(this.name).value(value);
    }
    @Override
    public Gen width(String width) {
        return new Element(this.name).width(width);
    }
    @Override
    public Gen width(Optional<String> width) {
        return new Element(this.name).width(width);
    }
    @Override
    public Gen wrap(String wrap) {
        return new Element(this.name).wrap(wrap);
    }
    @Override
    public Gen wrap(Optional<String> wrap) {
        return new Element(this.name).wrap(wrap);
    }

    @Override
    public String render() {
        return new Element(this.name).render();
    }
}