package com.opentangerine.genotype.html;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Grzegorz Gajos
 */
class Element implements Gen {
    private El el;

    public Element(String name) {
        this.el = new El(name);
    }

    public Gen in(Renderable... tags) {
        this.el.in(tags);
        return this;
    }

    public Gen in(String tags) {
        this.el.in(tags);
        return this;
    }

    public Gen in(Stream<Renderable> stream) {
        this.el.in(stream);
        return this;
    }

    public Gen attr(String key) {
        this.el.attr(key);
        return this;
    }

    public Gen attr(String key, String value) {
        return this.attr(key, Optional.ofNullable(value));
    }

    public Gen attr(String key, Optional<String> value) {
        this.el.attr(key, value);
        return this;
    }

    public Gen accept(String accept) {
        return this.accept(Optional.ofNullable(accept));
    }
    public Gen accept(Optional<String> accept) {
        return this.attr("accept", accept);
    }
    public Gen accept_charset(String accept_charset) {
        return this.accept_charset(Optional.ofNullable(accept_charset));
    }
    public Gen accept_charset(Optional<String> accept_charset) {
        return this.attr("accept-charset", accept_charset);
    }
    public Gen accesskey(String accesskey) {
        return this.accesskey(Optional.ofNullable(accesskey));
    }
    public Gen accesskey(Optional<String> accesskey) {
        return this.attr("accesskey", accesskey);
    }
    public Gen action(String action) {
        return this.action(Optional.ofNullable(action));
    }
    public Gen action(Optional<String> action) {
        return this.attr("action", action);
    }
    public Gen align(String align) {
        return this.align(Optional.ofNullable(align));
    }
    public Gen align(Optional<String> align) {
        return this.attr("align", align);
    }
    public Gen alt(String alt) {
        return this.alt(Optional.ofNullable(alt));
    }
    public Gen alt(Optional<String> alt) {
        return this.attr("alt", alt);
    }
    public Gen async(String async) {
        return this.async(Optional.ofNullable(async));
    }
    public Gen async(Optional<String> async) {
        return this.attr("async", async);
    }
    public Gen autocomplete(String autocomplete) {
        return this.autocomplete(Optional.ofNullable(autocomplete));
    }
    public Gen autocomplete(Optional<String> autocomplete) {
        return this.attr("autocomplete", autocomplete);
    }
    public Gen autofocus(String autofocus) {
        return this.autofocus(Optional.ofNullable(autofocus));
    }
    public Gen autofocus(Optional<String> autofocus) {
        return this.attr("autofocus", autofocus);
    }
    public Gen autoplay(String autoplay) {
        return this.autoplay(Optional.ofNullable(autoplay));
    }
    public Gen autoplay(Optional<String> autoplay) {
        return this.attr("autoplay", autoplay);
    }
    public Gen bgcolor(String bgcolor) {
        return this.bgcolor(Optional.ofNullable(bgcolor));
    }
    public Gen bgcolor(Optional<String> bgcolor) {
        return this.attr("bgcolor", bgcolor);
    }
    public Gen border(String border) {
        return this.border(Optional.ofNullable(border));
    }
    public Gen border(Optional<String> border) {
        return this.attr("border", border);
    }
    public Gen challenge(String challenge) {
        return this.challenge(Optional.ofNullable(challenge));
    }
    public Gen challenge(Optional<String> challenge) {
        return this.attr("challenge", challenge);
    }
    public Gen charset(String charset) {
        return this.charset(Optional.ofNullable(charset));
    }
    public Gen charset(Optional<String> charset) {
        return this.attr("charset", charset);
    }
    public Gen checked(String checked) {
        return this.checked(Optional.ofNullable(checked));
    }
    public Gen checked(Optional<String> checked) {
        return this.attr("checked", checked);
    }
    public Gen cite(String cite) {
        return this.cite(Optional.ofNullable(cite));
    }
    public Gen cite(Optional<String> cite) {
        return this.attr("cite", cite);
    }
    public Gen classAttr(String classAttr) {
        return this.classAttr(Optional.ofNullable(classAttr));
    }
    public Gen classAttr(Optional<String> classAttr) {
        return this.attr("class", classAttr);
    }
    public Gen color(String color) {
        return this.color(Optional.ofNullable(color));
    }
    public Gen color(Optional<String> color) {
        return this.attr("color", color);
    }
    public Gen cols(String cols) {
        return this.cols(Optional.ofNullable(cols));
    }
    public Gen cols(Optional<String> cols) {
        return this.attr("cols", cols);
    }
    public Gen colspan(String colspan) {
        return this.colspan(Optional.ofNullable(colspan));
    }
    public Gen colspan(Optional<String> colspan) {
        return this.attr("colspan", colspan);
    }
    public Gen content(String content) {
        return this.content(Optional.ofNullable(content));
    }
    public Gen content(Optional<String> content) {
        return this.attr("content", content);
    }
    public Gen contenteditable(String contenteditable) {
        return this.contenteditable(Optional.ofNullable(contenteditable));
    }
    public Gen contenteditable(Optional<String> contenteditable) {
        return this.attr("contenteditable", contenteditable);
    }
    public Gen contextmenu(String contextmenu) {
        return this.contextmenu(Optional.ofNullable(contextmenu));
    }
    public Gen contextmenu(Optional<String> contextmenu) {
        return this.attr("contextmenu", contextmenu);
    }
    public Gen controls(String controls) {
        return this.controls(Optional.ofNullable(controls));
    }
    public Gen controls(Optional<String> controls) {
        return this.attr("controls", controls);
    }
    public Gen coords(String coords) {
        return this.coords(Optional.ofNullable(coords));
    }
    public Gen coords(Optional<String> coords) {
        return this.attr("coords", coords);
    }
    public Gen data(String data) {
        return this.data(Optional.ofNullable(data));
    }
    public Gen data(Optional<String> data) {
        return this.attr("data", data);
    }
    public Gen datetime(String datetime) {
        return this.datetime(Optional.ofNullable(datetime));
    }
    public Gen datetime(Optional<String> datetime) {
        return this.attr("datetime", datetime);
    }
    public Gen defaultAttr(String defaultAttr) {
        return this.defaultAttr(Optional.ofNullable(defaultAttr));
    }
    public Gen defaultAttr(Optional<String> defaultAttr) {
        return this.attr("default", defaultAttr);
    }
    public Gen defer(String defer) {
        return this.defer(Optional.ofNullable(defer));
    }
    public Gen defer(Optional<String> defer) {
        return this.attr("defer", defer);
    }
    public Gen dir(String dir) {
        return this.dir(Optional.ofNullable(dir));
    }
    public Gen dir(Optional<String> dir) {
        return this.attr("dir", dir);
    }
    public Gen dirname(String dirname) {
        return this.dirname(Optional.ofNullable(dirname));
    }
    public Gen dirname(Optional<String> dirname) {
        return this.attr("dirname", dirname);
    }
    public Gen disabled(String disabled) {
        return this.disabled(Optional.ofNullable(disabled));
    }
    public Gen disabled(Optional<String> disabled) {
        return this.attr("disabled", disabled);
    }
    public Gen download(String download) {
        return this.download(Optional.ofNullable(download));
    }
    public Gen download(Optional<String> download) {
        return this.attr("download", download);
    }
    public Gen draggable(String draggable) {
        return this.draggable(Optional.ofNullable(draggable));
    }
    public Gen draggable(Optional<String> draggable) {
        return this.attr("draggable", draggable);
    }
    public Gen dropzone(String dropzone) {
        return this.dropzone(Optional.ofNullable(dropzone));
    }
    public Gen dropzone(Optional<String> dropzone) {
        return this.attr("dropzone", dropzone);
    }
    public Gen enctype(String enctype) {
        return this.enctype(Optional.ofNullable(enctype));
    }
    public Gen enctype(Optional<String> enctype) {
        return this.attr("enctype", enctype);
    }
    public Gen forAttr(String forAttr) {
        return this.forAttr(Optional.ofNullable(forAttr));
    }
    public Gen forAttr(Optional<String> forAttr) {
        return this.attr("for", forAttr);
    }
    public Gen form(String form) {
        return this.form(Optional.ofNullable(form));
    }
    public Gen form(Optional<String> form) {
        return this.attr("form", form);
    }
    public Gen formaction(String formaction) {
        return this.formaction(Optional.ofNullable(formaction));
    }
    public Gen formaction(Optional<String> formaction) {
        return this.attr("formaction", formaction);
    }
    public Gen headers(String headers) {
        return this.headers(Optional.ofNullable(headers));
    }
    public Gen headers(Optional<String> headers) {
        return this.attr("headers", headers);
    }
    public Gen height(String height) {
        return this.height(Optional.ofNullable(height));
    }
    public Gen height(Optional<String> height) {
        return this.attr("height", height);
    }
    public Gen hidden(String hidden) {
        return this.hidden(Optional.ofNullable(hidden));
    }
    public Gen hidden(Optional<String> hidden) {
        return this.attr("hidden", hidden);
    }
    public Gen high(String high) {
        return this.high(Optional.ofNullable(high));
    }
    public Gen high(Optional<String> high) {
        return this.attr("high", high);
    }
    public Gen href(String href) {
        return this.href(Optional.ofNullable(href));
    }
    public Gen href(Optional<String> href) {
        return this.attr("href", href);
    }
    public Gen hreflang(String hreflang) {
        return this.hreflang(Optional.ofNullable(hreflang));
    }
    public Gen hreflang(Optional<String> hreflang) {
        return this.attr("hreflang", hreflang);
    }
    public Gen http_equiv(String http_equiv) {
        return this.http_equiv(Optional.ofNullable(http_equiv));
    }
    public Gen http_equiv(Optional<String> http_equiv) {
        return this.attr("http-equiv", http_equiv);
    }
    public Gen id(String id) {
        return this.id(Optional.ofNullable(id));
    }
    public Gen id(Optional<String> id) {
        return this.attr("id", id);
    }
    public Gen ismap(String ismap) {
        return this.ismap(Optional.ofNullable(ismap));
    }
    public Gen ismap(Optional<String> ismap) {
        return this.attr("ismap", ismap);
    }
    public Gen keytype(String keytype) {
        return this.keytype(Optional.ofNullable(keytype));
    }
    public Gen keytype(Optional<String> keytype) {
        return this.attr("keytype", keytype);
    }
    public Gen kind(String kind) {
        return this.kind(Optional.ofNullable(kind));
    }
    public Gen kind(Optional<String> kind) {
        return this.attr("kind", kind);
    }
    public Gen label(String label) {
        return this.label(Optional.ofNullable(label));
    }
    public Gen label(Optional<String> label) {
        return this.attr("label", label);
    }
    public Gen lang(String lang) {
        return this.lang(Optional.ofNullable(lang));
    }
    public Gen lang(Optional<String> lang) {
        return this.attr("lang", lang);
    }
    public Gen list(String list) {
        return this.list(Optional.ofNullable(list));
    }
    public Gen list(Optional<String> list) {
        return this.attr("list", list);
    }
    public Gen loop(String loop) {
        return this.loop(Optional.ofNullable(loop));
    }
    public Gen loop(Optional<String> loop) {
        return this.attr("loop", loop);
    }
    public Gen low(String low) {
        return this.low(Optional.ofNullable(low));
    }
    public Gen low(Optional<String> low) {
        return this.attr("low", low);
    }
    public Gen manifest(String manifest) {
        return this.manifest(Optional.ofNullable(manifest));
    }
    public Gen manifest(Optional<String> manifest) {
        return this.attr("manifest", manifest);
    }
    public Gen max(String max) {
        return this.max(Optional.ofNullable(max));
    }
    public Gen max(Optional<String> max) {
        return this.attr("max", max);
    }
    public Gen maxlength(String maxlength) {
        return this.maxlength(Optional.ofNullable(maxlength));
    }
    public Gen maxlength(Optional<String> maxlength) {
        return this.attr("maxlength", maxlength);
    }
    public Gen media(String media) {
        return this.media(Optional.ofNullable(media));
    }
    public Gen media(Optional<String> media) {
        return this.attr("media", media);
    }
    public Gen method(String method) {
        return this.method(Optional.ofNullable(method));
    }
    public Gen method(Optional<String> method) {
        return this.attr("method", method);
    }
    public Gen min(String min) {
        return this.min(Optional.ofNullable(min));
    }
    public Gen min(Optional<String> min) {
        return this.attr("min", min);
    }
    public Gen multiple(String multiple) {
        return this.multiple(Optional.ofNullable(multiple));
    }
    public Gen multiple(Optional<String> multiple) {
        return this.attr("multiple", multiple);
    }
    public Gen muted(String muted) {
        return this.muted(Optional.ofNullable(muted));
    }
    public Gen muted(Optional<String> muted) {
        return this.attr("muted", muted);
    }
    public Gen name(String name) {
        return this.name(Optional.ofNullable(name));
    }
    public Gen name(Optional<String> name) {
        return this.attr("name", name);
    }
    public Gen novalidate(String novalidate) {
        return this.novalidate(Optional.ofNullable(novalidate));
    }
    public Gen novalidate(Optional<String> novalidate) {
        return this.attr("novalidate", novalidate);
    }
    public Gen onabort(String onabort) {
        return this.onabort(Optional.ofNullable(onabort));
    }
    public Gen onabort(Optional<String> onabort) {
        return this.attr("onabort", onabort);
    }
    public Gen onafterprint(String onafterprint) {
        return this.onafterprint(Optional.ofNullable(onafterprint));
    }
    public Gen onafterprint(Optional<String> onafterprint) {
        return this.attr("onafterprint", onafterprint);
    }
    public Gen onbeforeprint(String onbeforeprint) {
        return this.onbeforeprint(Optional.ofNullable(onbeforeprint));
    }
    public Gen onbeforeprint(Optional<String> onbeforeprint) {
        return this.attr("onbeforeprint", onbeforeprint);
    }
    public Gen onbeforeunload(String onbeforeunload) {
        return this.onbeforeunload(Optional.ofNullable(onbeforeunload));
    }
    public Gen onbeforeunload(Optional<String> onbeforeunload) {
        return this.attr("onbeforeunload", onbeforeunload);
    }
    public Gen onblur(String onblur) {
        return this.onblur(Optional.ofNullable(onblur));
    }
    public Gen onblur(Optional<String> onblur) {
        return this.attr("onblur", onblur);
    }
    public Gen oncanplay(String oncanplay) {
        return this.oncanplay(Optional.ofNullable(oncanplay));
    }
    public Gen oncanplay(Optional<String> oncanplay) {
        return this.attr("oncanplay", oncanplay);
    }
    public Gen oncanplaythrough(String oncanplaythrough) {
        return this.oncanplaythrough(Optional.ofNullable(oncanplaythrough));
    }
    public Gen oncanplaythrough(Optional<String> oncanplaythrough) {
        return this.attr("oncanplaythrough", oncanplaythrough);
    }
    public Gen onchange(String onchange) {
        return this.onchange(Optional.ofNullable(onchange));
    }
    public Gen onchange(Optional<String> onchange) {
        return this.attr("onchange", onchange);
    }
    public Gen onclick(String onclick) {
        return this.onclick(Optional.ofNullable(onclick));
    }
    public Gen onclick(Optional<String> onclick) {
        return this.attr("onclick", onclick);
    }
    public Gen oncontextmenu(String oncontextmenu) {
        return this.oncontextmenu(Optional.ofNullable(oncontextmenu));
    }
    public Gen oncontextmenu(Optional<String> oncontextmenu) {
        return this.attr("oncontextmenu", oncontextmenu);
    }
    public Gen oncopy(String oncopy) {
        return this.oncopy(Optional.ofNullable(oncopy));
    }
    public Gen oncopy(Optional<String> oncopy) {
        return this.attr("oncopy", oncopy);
    }
    public Gen oncuechange(String oncuechange) {
        return this.oncuechange(Optional.ofNullable(oncuechange));
    }
    public Gen oncuechange(Optional<String> oncuechange) {
        return this.attr("oncuechange", oncuechange);
    }
    public Gen oncut(String oncut) {
        return this.oncut(Optional.ofNullable(oncut));
    }
    public Gen oncut(Optional<String> oncut) {
        return this.attr("oncut", oncut);
    }
    public Gen ondblclick(String ondblclick) {
        return this.ondblclick(Optional.ofNullable(ondblclick));
    }
    public Gen ondblclick(Optional<String> ondblclick) {
        return this.attr("ondblclick", ondblclick);
    }
    public Gen ondrag(String ondrag) {
        return this.ondrag(Optional.ofNullable(ondrag));
    }
    public Gen ondrag(Optional<String> ondrag) {
        return this.attr("ondrag", ondrag);
    }
    public Gen ondragend(String ondragend) {
        return this.ondragend(Optional.ofNullable(ondragend));
    }
    public Gen ondragend(Optional<String> ondragend) {
        return this.attr("ondragend", ondragend);
    }
    public Gen ondragenter(String ondragenter) {
        return this.ondragenter(Optional.ofNullable(ondragenter));
    }
    public Gen ondragenter(Optional<String> ondragenter) {
        return this.attr("ondragenter", ondragenter);
    }
    public Gen ondragleave(String ondragleave) {
        return this.ondragleave(Optional.ofNullable(ondragleave));
    }
    public Gen ondragleave(Optional<String> ondragleave) {
        return this.attr("ondragleave", ondragleave);
    }
    public Gen ondragover(String ondragover) {
        return this.ondragover(Optional.ofNullable(ondragover));
    }
    public Gen ondragover(Optional<String> ondragover) {
        return this.attr("ondragover", ondragover);
    }
    public Gen ondragstart(String ondragstart) {
        return this.ondragstart(Optional.ofNullable(ondragstart));
    }
    public Gen ondragstart(Optional<String> ondragstart) {
        return this.attr("ondragstart", ondragstart);
    }
    public Gen ondrop(String ondrop) {
        return this.ondrop(Optional.ofNullable(ondrop));
    }
    public Gen ondrop(Optional<String> ondrop) {
        return this.attr("ondrop", ondrop);
    }
    public Gen ondurationchange(String ondurationchange) {
        return this.ondurationchange(Optional.ofNullable(ondurationchange));
    }
    public Gen ondurationchange(Optional<String> ondurationchange) {
        return this.attr("ondurationchange", ondurationchange);
    }
    public Gen onemptied(String onemptied) {
        return this.onemptied(Optional.ofNullable(onemptied));
    }
    public Gen onemptied(Optional<String> onemptied) {
        return this.attr("onemptied", onemptied);
    }
    public Gen onended(String onended) {
        return this.onended(Optional.ofNullable(onended));
    }
    public Gen onended(Optional<String> onended) {
        return this.attr("onended", onended);
    }
    public Gen onerror(String onerror) {
        return this.onerror(Optional.ofNullable(onerror));
    }
    public Gen onerror(Optional<String> onerror) {
        return this.attr("onerror", onerror);
    }
    public Gen onfocus(String onfocus) {
        return this.onfocus(Optional.ofNullable(onfocus));
    }
    public Gen onfocus(Optional<String> onfocus) {
        return this.attr("onfocus", onfocus);
    }
    public Gen onhashchange(String onhashchange) {
        return this.onhashchange(Optional.ofNullable(onhashchange));
    }
    public Gen onhashchange(Optional<String> onhashchange) {
        return this.attr("onhashchange", onhashchange);
    }
    public Gen oninput(String oninput) {
        return this.oninput(Optional.ofNullable(oninput));
    }
    public Gen oninput(Optional<String> oninput) {
        return this.attr("oninput", oninput);
    }
    public Gen oninvalid(String oninvalid) {
        return this.oninvalid(Optional.ofNullable(oninvalid));
    }
    public Gen oninvalid(Optional<String> oninvalid) {
        return this.attr("oninvalid", oninvalid);
    }
    public Gen onkeydown(String onkeydown) {
        return this.onkeydown(Optional.ofNullable(onkeydown));
    }
    public Gen onkeydown(Optional<String> onkeydown) {
        return this.attr("onkeydown", onkeydown);
    }
    public Gen onkeypress(String onkeypress) {
        return this.onkeypress(Optional.ofNullable(onkeypress));
    }
    public Gen onkeypress(Optional<String> onkeypress) {
        return this.attr("onkeypress", onkeypress);
    }
    public Gen onkeyup(String onkeyup) {
        return this.onkeyup(Optional.ofNullable(onkeyup));
    }
    public Gen onkeyup(Optional<String> onkeyup) {
        return this.attr("onkeyup", onkeyup);
    }
    public Gen onload(String onload) {
        return this.onload(Optional.ofNullable(onload));
    }
    public Gen onload(Optional<String> onload) {
        return this.attr("onload", onload);
    }
    public Gen onloadeddata(String onloadeddata) {
        return this.onloadeddata(Optional.ofNullable(onloadeddata));
    }
    public Gen onloadeddata(Optional<String> onloadeddata) {
        return this.attr("onloadeddata", onloadeddata);
    }
    public Gen onloadedmetadata(String onloadedmetadata) {
        return this.onloadedmetadata(Optional.ofNullable(onloadedmetadata));
    }
    public Gen onloadedmetadata(Optional<String> onloadedmetadata) {
        return this.attr("onloadedmetadata", onloadedmetadata);
    }
    public Gen onloadstart(String onloadstart) {
        return this.onloadstart(Optional.ofNullable(onloadstart));
    }
    public Gen onloadstart(Optional<String> onloadstart) {
        return this.attr("onloadstart", onloadstart);
    }
    public Gen onmousedown(String onmousedown) {
        return this.onmousedown(Optional.ofNullable(onmousedown));
    }
    public Gen onmousedown(Optional<String> onmousedown) {
        return this.attr("onmousedown", onmousedown);
    }
    public Gen onmousemove(String onmousemove) {
        return this.onmousemove(Optional.ofNullable(onmousemove));
    }
    public Gen onmousemove(Optional<String> onmousemove) {
        return this.attr("onmousemove", onmousemove);
    }
    public Gen onmouseout(String onmouseout) {
        return this.onmouseout(Optional.ofNullable(onmouseout));
    }
    public Gen onmouseout(Optional<String> onmouseout) {
        return this.attr("onmouseout", onmouseout);
    }
    public Gen onmouseover(String onmouseover) {
        return this.onmouseover(Optional.ofNullable(onmouseover));
    }
    public Gen onmouseover(Optional<String> onmouseover) {
        return this.attr("onmouseover", onmouseover);
    }
    public Gen onmouseup(String onmouseup) {
        return this.onmouseup(Optional.ofNullable(onmouseup));
    }
    public Gen onmouseup(Optional<String> onmouseup) {
        return this.attr("onmouseup", onmouseup);
    }
    public Gen onmousewheel(String onmousewheel) {
        return this.onmousewheel(Optional.ofNullable(onmousewheel));
    }
    public Gen onmousewheel(Optional<String> onmousewheel) {
        return this.attr("onmousewheel", onmousewheel);
    }
    public Gen onoffline(String onoffline) {
        return this.onoffline(Optional.ofNullable(onoffline));
    }
    public Gen onoffline(Optional<String> onoffline) {
        return this.attr("onoffline", onoffline);
    }
    public Gen ononline(String ononline) {
        return this.ononline(Optional.ofNullable(ononline));
    }
    public Gen ononline(Optional<String> ononline) {
        return this.attr("ononline", ononline);
    }
    public Gen onpagehide(String onpagehide) {
        return this.onpagehide(Optional.ofNullable(onpagehide));
    }
    public Gen onpagehide(Optional<String> onpagehide) {
        return this.attr("onpagehide", onpagehide);
    }
    public Gen onpageshow(String onpageshow) {
        return this.onpageshow(Optional.ofNullable(onpageshow));
    }
    public Gen onpageshow(Optional<String> onpageshow) {
        return this.attr("onpageshow", onpageshow);
    }
    public Gen onpaste(String onpaste) {
        return this.onpaste(Optional.ofNullable(onpaste));
    }
    public Gen onpaste(Optional<String> onpaste) {
        return this.attr("onpaste", onpaste);
    }
    public Gen onpause(String onpause) {
        return this.onpause(Optional.ofNullable(onpause));
    }
    public Gen onpause(Optional<String> onpause) {
        return this.attr("onpause", onpause);
    }
    public Gen onplay(String onplay) {
        return this.onplay(Optional.ofNullable(onplay));
    }
    public Gen onplay(Optional<String> onplay) {
        return this.attr("onplay", onplay);
    }
    public Gen onplaying(String onplaying) {
        return this.onplaying(Optional.ofNullable(onplaying));
    }
    public Gen onplaying(Optional<String> onplaying) {
        return this.attr("onplaying", onplaying);
    }
    public Gen onpopstate(String onpopstate) {
        return this.onpopstate(Optional.ofNullable(onpopstate));
    }
    public Gen onpopstate(Optional<String> onpopstate) {
        return this.attr("onpopstate", onpopstate);
    }
    public Gen onprogress(String onprogress) {
        return this.onprogress(Optional.ofNullable(onprogress));
    }
    public Gen onprogress(Optional<String> onprogress) {
        return this.attr("onprogress", onprogress);
    }
    public Gen onratechange(String onratechange) {
        return this.onratechange(Optional.ofNullable(onratechange));
    }
    public Gen onratechange(Optional<String> onratechange) {
        return this.attr("onratechange", onratechange);
    }
    public Gen onreset(String onreset) {
        return this.onreset(Optional.ofNullable(onreset));
    }
    public Gen onreset(Optional<String> onreset) {
        return this.attr("onreset", onreset);
    }
    public Gen onresize(String onresize) {
        return this.onresize(Optional.ofNullable(onresize));
    }
    public Gen onresize(Optional<String> onresize) {
        return this.attr("onresize", onresize);
    }
    public Gen onscroll(String onscroll) {
        return this.onscroll(Optional.ofNullable(onscroll));
    }
    public Gen onscroll(Optional<String> onscroll) {
        return this.attr("onscroll", onscroll);
    }
    public Gen onsearch(String onsearch) {
        return this.onsearch(Optional.ofNullable(onsearch));
    }
    public Gen onsearch(Optional<String> onsearch) {
        return this.attr("onsearch", onsearch);
    }
    public Gen onseeked(String onseeked) {
        return this.onseeked(Optional.ofNullable(onseeked));
    }
    public Gen onseeked(Optional<String> onseeked) {
        return this.attr("onseeked", onseeked);
    }
    public Gen onseeking(String onseeking) {
        return this.onseeking(Optional.ofNullable(onseeking));
    }
    public Gen onseeking(Optional<String> onseeking) {
        return this.attr("onseeking", onseeking);
    }
    public Gen onselect(String onselect) {
        return this.onselect(Optional.ofNullable(onselect));
    }
    public Gen onselect(Optional<String> onselect) {
        return this.attr("onselect", onselect);
    }
    public Gen onshow(String onshow) {
        return this.onshow(Optional.ofNullable(onshow));
    }
    public Gen onshow(Optional<String> onshow) {
        return this.attr("onshow", onshow);
    }
    public Gen onstalled(String onstalled) {
        return this.onstalled(Optional.ofNullable(onstalled));
    }
    public Gen onstalled(Optional<String> onstalled) {
        return this.attr("onstalled", onstalled);
    }
    public Gen onstorage(String onstorage) {
        return this.onstorage(Optional.ofNullable(onstorage));
    }
    public Gen onstorage(Optional<String> onstorage) {
        return this.attr("onstorage", onstorage);
    }
    public Gen onsubmit(String onsubmit) {
        return this.onsubmit(Optional.ofNullable(onsubmit));
    }
    public Gen onsubmit(Optional<String> onsubmit) {
        return this.attr("onsubmit", onsubmit);
    }
    public Gen onsuspend(String onsuspend) {
        return this.onsuspend(Optional.ofNullable(onsuspend));
    }
    public Gen onsuspend(Optional<String> onsuspend) {
        return this.attr("onsuspend", onsuspend);
    }
    public Gen ontimeupdate(String ontimeupdate) {
        return this.ontimeupdate(Optional.ofNullable(ontimeupdate));
    }
    public Gen ontimeupdate(Optional<String> ontimeupdate) {
        return this.attr("ontimeupdate", ontimeupdate);
    }
    public Gen ontoggle(String ontoggle) {
        return this.ontoggle(Optional.ofNullable(ontoggle));
    }
    public Gen ontoggle(Optional<String> ontoggle) {
        return this.attr("ontoggle", ontoggle);
    }
    public Gen onunload(String onunload) {
        return this.onunload(Optional.ofNullable(onunload));
    }
    public Gen onunload(Optional<String> onunload) {
        return this.attr("onunload", onunload);
    }
    public Gen onvolumechange(String onvolumechange) {
        return this.onvolumechange(Optional.ofNullable(onvolumechange));
    }
    public Gen onvolumechange(Optional<String> onvolumechange) {
        return this.attr("onvolumechange", onvolumechange);
    }
    public Gen onwaiting(String onwaiting) {
        return this.onwaiting(Optional.ofNullable(onwaiting));
    }
    public Gen onwaiting(Optional<String> onwaiting) {
        return this.attr("onwaiting", onwaiting);
    }
    public Gen onwheel(String onwheel) {
        return this.onwheel(Optional.ofNullable(onwheel));
    }
    public Gen onwheel(Optional<String> onwheel) {
        return this.attr("onwheel", onwheel);
    }
    public Gen open(String open) {
        return this.open(Optional.ofNullable(open));
    }
    public Gen open(Optional<String> open) {
        return this.attr("open", open);
    }
    public Gen optimum(String optimum) {
        return this.optimum(Optional.ofNullable(optimum));
    }
    public Gen optimum(Optional<String> optimum) {
        return this.attr("optimum", optimum);
    }
    public Gen pattern(String pattern) {
        return this.pattern(Optional.ofNullable(pattern));
    }
    public Gen pattern(Optional<String> pattern) {
        return this.attr("pattern", pattern);
    }
    public Gen placeholder(String placeholder) {
        return this.placeholder(Optional.ofNullable(placeholder));
    }
    public Gen placeholder(Optional<String> placeholder) {
        return this.attr("placeholder", placeholder);
    }
    public Gen poster(String poster) {
        return this.poster(Optional.ofNullable(poster));
    }
    public Gen poster(Optional<String> poster) {
        return this.attr("poster", poster);
    }
    public Gen preload(String preload) {
        return this.preload(Optional.ofNullable(preload));
    }
    public Gen preload(Optional<String> preload) {
        return this.attr("preload", preload);
    }
    public Gen readonly(String readonly) {
        return this.readonly(Optional.ofNullable(readonly));
    }
    public Gen readonly(Optional<String> readonly) {
        return this.attr("readonly", readonly);
    }
    public Gen rel(String rel) {
        return this.rel(Optional.ofNullable(rel));
    }
    public Gen rel(Optional<String> rel) {
        return this.attr("rel", rel);
    }
    public Gen required(String required) {
        return this.required(Optional.ofNullable(required));
    }
    public Gen required(Optional<String> required) {
        return this.attr("required", required);
    }
    public Gen reversed(String reversed) {
        return this.reversed(Optional.ofNullable(reversed));
    }
    public Gen reversed(Optional<String> reversed) {
        return this.attr("reversed", reversed);
    }
    public Gen rows(String rows) {
        return this.rows(Optional.ofNullable(rows));
    }
    public Gen rows(Optional<String> rows) {
        return this.attr("rows", rows);
    }
    public Gen rowspan(String rowspan) {
        return this.rowspan(Optional.ofNullable(rowspan));
    }
    public Gen rowspan(Optional<String> rowspan) {
        return this.attr("rowspan", rowspan);
    }
    public Gen sandbox(String sandbox) {
        return this.sandbox(Optional.ofNullable(sandbox));
    }
    public Gen sandbox(Optional<String> sandbox) {
        return this.attr("sandbox", sandbox);
    }
    public Gen scope(String scope) {
        return this.scope(Optional.ofNullable(scope));
    }
    public Gen scope(Optional<String> scope) {
        return this.attr("scope", scope);
    }
    public Gen scoped(String scoped) {
        return this.scoped(Optional.ofNullable(scoped));
    }
    public Gen scoped(Optional<String> scoped) {
        return this.attr("scoped", scoped);
    }
    public Gen selected(String selected) {
        return this.selected(Optional.ofNullable(selected));
    }
    public Gen selected(Optional<String> selected) {
        return this.attr("selected", selected);
    }
    public Gen shape(String shape) {
        return this.shape(Optional.ofNullable(shape));
    }
    public Gen shape(Optional<String> shape) {
        return this.attr("shape", shape);
    }
    public Gen size(String size) {
        return this.size(Optional.ofNullable(size));
    }
    public Gen size(Optional<String> size) {
        return this.attr("size", size);
    }
    public Gen sizes(String sizes) {
        return this.sizes(Optional.ofNullable(sizes));
    }
    public Gen sizes(Optional<String> sizes) {
        return this.attr("sizes", sizes);
    }
    public Gen span(String span) {
        return this.span(Optional.ofNullable(span));
    }
    public Gen span(Optional<String> span) {
        return this.attr("span", span);
    }
    public Gen spellcheck(String spellcheck) {
        return this.spellcheck(Optional.ofNullable(spellcheck));
    }
    public Gen spellcheck(Optional<String> spellcheck) {
        return this.attr("spellcheck", spellcheck);
    }
    public Gen src(String src) {
        return this.src(Optional.ofNullable(src));
    }
    public Gen src(Optional<String> src) {
        return this.attr("src", src);
    }
    public Gen srcdoc(String srcdoc) {
        return this.srcdoc(Optional.ofNullable(srcdoc));
    }
    public Gen srcdoc(Optional<String> srcdoc) {
        return this.attr("srcdoc", srcdoc);
    }
    public Gen srclang(String srclang) {
        return this.srclang(Optional.ofNullable(srclang));
    }
    public Gen srclang(Optional<String> srclang) {
        return this.attr("srclang", srclang);
    }
    public Gen start(String start) {
        return this.start(Optional.ofNullable(start));
    }
    public Gen start(Optional<String> start) {
        return this.attr("start", start);
    }
    public Gen step(String step) {
        return this.step(Optional.ofNullable(step));
    }
    public Gen step(Optional<String> step) {
        return this.attr("step", step);
    }
    public Gen style(String style) {
        return this.style(Optional.ofNullable(style));
    }
    public Gen style(Optional<String> style) {
        return this.attr("style", style);
    }
    public Gen tabindex(String tabindex) {
        return this.tabindex(Optional.ofNullable(tabindex));
    }
    public Gen tabindex(Optional<String> tabindex) {
        return this.attr("tabindex", tabindex);
    }
    public Gen target(String target) {
        return this.target(Optional.ofNullable(target));
    }
    public Gen target(Optional<String> target) {
        return this.attr("target", target);
    }
    public Gen title(String title) {
        return this.title(Optional.ofNullable(title));
    }
    public Gen title(Optional<String> title) {
        return this.attr("title", title);
    }
    public Gen translate(String translate) {
        return this.translate(Optional.ofNullable(translate));
    }
    public Gen translate(Optional<String> translate) {
        return this.attr("translate", translate);
    }
    public Gen type(String type) {
        return this.type(Optional.ofNullable(type));
    }
    public Gen type(Optional<String> type) {
        return this.attr("type", type);
    }
    public Gen usemap(String usemap) {
        return this.usemap(Optional.ofNullable(usemap));
    }
    public Gen usemap(Optional<String> usemap) {
        return this.attr("usemap", usemap);
    }
    public Gen value(String value) {
        return this.value(Optional.ofNullable(value));
    }
    public Gen value(Optional<String> value) {
        return this.attr("value", value);
    }
    public Gen width(String width) {
        return this.width(Optional.ofNullable(width));
    }
    public Gen width(Optional<String> width) {
        return this.attr("width", width);
    }
    public Gen wrap(String wrap) {
        return this.wrap(Optional.ofNullable(wrap));
    }
    public Gen wrap(Optional<String> wrap) {
        return this.attr("wrap", wrap);
    }

    @Override
    public String render() {
        return el.render();
    }
}