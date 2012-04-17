/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.html4.element;

/**
 * This enum gives the different attributes of html4 elements
 *
 * @author dev@testatoo.org
 */
public enum Attribute {
    src("src"), type("type"), maxlength("maxlength"), lang("lang"), value("value"), dir("dir"), label("label"),
    selected("selected"), action("action"), summary("summary"), width("width"), border("border"), frame("frame"),
    rules("rules"), cellspacing("cellspacing"), cellpadding("cellpadding"), cellhalign("cellHAlign"),
    cellvalign("cellvalign"), span("span"), abbr("abbr"), rowspan("rowspan"), colspan("colspan"), axis("axis"),
    headers("headers"), scope("scope"), nohref("nohref"), media("media"), rows("rows"), cols("cols"), _for("for"),
    ismap("ismap"), readonly("readonly"), href("href"), clazz("class"), frameborder("frameborder"),
    marginwidth("marginWidth"), marginheight("marginHeight"), noresize("noresize"), scrolling("scrolling"),
    classid("classid"), codebase("codeBase"), data("data"), codetype("codeType"), archive("archive"), valuetype("valueType"),
    standby("standby"), height("height"), style("style"), title("title"), multiple("multiple"), size("size"),
    alt("alt"), tabindex("tabindex"), accesskey("accessKey"), name("name"), longdesc("longDesc"), usemap("usemap"),
    charset("charset"), hreflang("hreflang"), rel("rel"), rev("rev"), shape("shape"), coords("coords"),
    method("method"), enctype("enctype"), accept("accept"), acceptcharset("accept-charset"), defer("defer"), checked("checked");

    private String _value;

    private Attribute(String value) {
        _value = value;
    }

    public String toString() {
        return _value;
    }

}
