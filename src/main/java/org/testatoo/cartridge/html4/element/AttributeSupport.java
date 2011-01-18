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

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.core.component.Component;

/**
 * This class allows to test the value of specific attributes on html tags.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/index/attributes.html">html attributes specifications </a>
 */

public final class AttributeSupport {

    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use.
     *
     * @param evaluator a UI Test engine specific html evaluator
     */
    AttributeSupport(HtmlEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * To get the value attribute of the html element (ex : input, button, li, ...)
     *
     * @param component the html element
     * @return the value attribute of the html element
     */
    String value(Component component) {
        return evaluator.attribute(component.id(), Attribute.value);
    }

    /**
     * To get the alt attribute of the html element (ex : input, area, ...)
     *
     * @param component the html element
     * @return the alt attribute of the html element
     */
    String alt(Component component) {
        return evaluator.attribute(component.id(), Attribute.alt);
    }

    /**
     * To get the tabindex attribute of the html element (ex : a, button, textarea, ...)
     *
     * @param component the html element
     * @return the tabindex attribute of the html element
     */
    Integer tabindex(Component component) {
        String tabIndex = evaluator.attribute(component.id(), Attribute.tabindex);
        if (tabIndex.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(tabIndex);
    }

    /**
     * To get the accesskey attribute of the html element (ex : input, button, label, ...)
     *
     * @param component the html element
     * @return the accesskey attribute of the html element
     */
    String accesskey(Component component) {
        return evaluator.attribute(component.id(), Attribute.accesskey);
    }

    /**
     * To get the size attribute of the html element (ex : input, hr, select, ...)
     *
     * @param component the html element
     * @return the size attribute of the html element, default is 0
     */
    Integer size(Component component) {
        String size = evaluator.attribute(component.id(), Attribute.size);
        if (size.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(size);
    }

    /**
     * To get the name attribute of the html element (ex : a, button, img, ...)
     *
     * @param component the html element
     * @return the name attribute of the html element
     */
    String name(Component component) {
        return evaluator.attribute(component.id(), Attribute.name);
    }

    /**
     * To get the longdesc attribute of the html element (ex : img, frame, ...)
     *
     * @param component the html element
     * @return the longdesc attribute of the html element
     */
    String longdesc(Component component) {
        return evaluator.attribute(component.id(), Attribute.longdesc);
    }

    /**
     * To get the usemap attribute of the html element (ex : input, img, ...)
     *
     * @param component the html element
     * @return the usemap attribute of the html element
     */
    String usemap(Component component) {
        return evaluator.attribute(component.id(), Attribute.usemap);
    }

    /**
     * To get the charset attribute of the html element (ex : a, link, ...)
     *
     * @param component the html element
     * @return the charset attribute of the html element
     */
    String charset(Component component) {
        return evaluator.attribute(component.id(), Attribute.charset);
    }

    /**
     * To get the href attribute of the html element (ex : a, area, link, ...)
     *
     * @param component the html element
     * @return the href attribute of the html element
     */
    String href(Component component) {
        return evaluator.attribute(component.id(), Attribute.href);
    }

    /**
     * To get the hreflang attribute of the html element (a, link)
     *
     * @param component the html element
     * @return the hreflang attribute of the html element
     */
    String hreflang(Component component) {
        return evaluator.attribute(component.id(), Attribute.hreflang);
    }

    /**
     * To get the rel attribute of the html element (a, link)
     *
     * @param component the html element
     * @return the rel attribute of the html element
     */
    String rel(Component component) {
        return evaluator.attribute(component.id(), Attribute.rel);
    }

    /**
     * To get the rev attribute of the html element (a, link)
     *
     * @param component the html element
     * @return the rev attribute of the html element
     */
    String rev(Component component) {
        return evaluator.attribute(component.id(), Attribute.rev);
    }

    /**
     * To get the shape attribute of the html element (a, area)
     *
     * @param component the html element
     * @return the shape attribute of the html element
     */
    Shape shape(Component component) {
        return Shape.valueOf(evaluator.attribute(component.id(), Attribute.shape).toLowerCase());
    }

    /**
     * To get the coords attribute of the html element (a, area)
     *
     * @param component the html element
     * @return the coords attribute of the html element
     */
    String coords(Component component) {
        return evaluator.attribute(component.id(), Attribute.coords);
    }

    /**
     * To get the type attribute of a "input" element
     *
     * @param inputText the "input" element
     * @return the type attribute of the input element
     */
    InputType inputType(InputText inputText) {
        return InputType.valueOf(evaluator.attribute(inputText.id(), Attribute.type).toLowerCase());
    }

    /**
     * To get the type attribute of the html element (different from inputText, ex : a, link, ...)
     *
     * @param component the html element
     * @return the type attribute of the html element
     */
    String type(Component component) {
        return evaluator.attribute(component.id(), Attribute.type);
    }

    /**
     * To get the method attribute of the "form" element
     *
     * @param form the "form" element
     * @return the method attribute of the "form" element
     */
    Method method(Form form) {
        String method = evaluator.attribute(form.id(), Attribute.method).toLowerCase();
        if (method.equals(""))
            return Method.get;
        return Method.valueOf(method);
    }

    /**
     * To get the action attribute of the "form" element
     *
     * @param form the "form" element
     * @return the action attribute of the "form" element
     */
    String action(Form form) {
        return evaluator.attribute(form.id(), Attribute.action);
    }

    /**
     * To get the enctype attribute of the "form" element
     *
     * @param form the "form" element
     * @return the enctype attribute of the "form" element, default is "application/x-www-form-urlencoded"
     */
    String enctype(Form form) {
        String enctype = evaluator.attribute(form.id(), Attribute.enctype);
        if (enctype.equals(""))
            return "application/x-www-form-urlencoded";
        return enctype;
    }

    /**
     * To get the accept attribute of the html element (form, input)
     *
     * @param component the html element
     * @return the accept attribute of the html element
     */
    String accept(Component component) {
        return evaluator.attribute(component.id(), Attribute.accept);
    }

    /**
     * To get the accept-charset attribute of the "form" element
     *
     * @param form the "form" element
     * @return the accept-charset attribute of the "form" element, default is "UNKNOWN"
     */
    String acceptCharset(Form form) {
        String acceptCharset = evaluator.attribute(form.id(), Attribute.acceptcharset);
        if (acceptCharset.equals(""))
            return "UNKNOWN";
        return acceptCharset;
    }

    /**
     * To get the summary attribute of the "table" element
     *
     * @param table the "table" element
     * @return the summary attribute of the "table" element
     */
    String summary(Table table) {
        return evaluator.attribute(table.id(), Attribute.summary);
    }

    /**
     * To get the width attribute of the html element (ex : img, table, col, ...)
     *
     * @param component the html element
     * @return the width attribute of the html element
     */
    String width(Component component) {
        return evaluator.attribute(component.id(), Attribute.width);
    }

    /**
     * To get the border attribute of the html element (ex : img, table, ...)
     *
     * @param component the html element
     * @return the border attribute of the html element, default is 0
     */
    Integer border(Component component) {
        String border = evaluator.attribute(component.id(), Attribute.border);
        if (border.isEmpty())
            return 0;
        else
            return Integer.parseInt(border);
    }

    /**
     * To get the frame attribute of the "table" element
     *
     * @param table the "table" element
     * @return the frame attribute of the "table" element
     */
    TFrame frame(Table table) {
        return TFrame.valueOf(evaluator.attribute(table.id(), Attribute.frame));
    }

    /**
     * To get the rules attribute of the "table" element
     *
     * @param table the "table" element
     * @return the rules attribute of the "table" element
     */
    TRules rules(Table table) {
        return TRules.valueOf(evaluator.attribute(table.id(), Attribute.rules));
    }

    /**
     * To get the cellspacing attribute of the "table" element
     *
     * @param table the "table" element
     * @return the cellspacing attribute of the "table" element
     */
    String cellspacing(Table table) {
        return evaluator.attribute(table.id(), Attribute.cellspacing);
    }

    /**
     * To get the cellpadding attribute of the "table" element
     *
     * @param table the "table" element
     * @return the cellpadding attribute of the "table" element
     */
    String cellpadding(Table table) {
        return evaluator.attribute(table.id(), Attribute.cellpadding);
    }

    /**
     * To get the cellhalign attribute of the html element (thead, tr, ...)
     *
     * @param component the html element
     * @return the cellhalign attribute of the html element
     */
    Cellhalign cellhalign(Component component) {
        return Cellhalign.valueOf(evaluator.attribute(component.id(), Attribute.cellhalign));
    }

    /**
     * To get the cellvalign attribute of the html element (thead, tr, ...)
     *
     * @param component the html element
     * @return the cellvalign attribute of the html element
     */
    Cellvalign cellvalign(Component component) {
        return Cellvalign.valueOf(evaluator.attribute(component.id(), Attribute.cellvalign));
    }

    /**
     * To get the span attribute of the html element (col, colgroup, ...)
     *
     * @param component the html element
     * @return the span attribute of the html element, default is 1
     */
    Integer span(Component component) {
        String span = evaluator.attribute(component.id(), Attribute.span);
        if (span.isEmpty()) {
            return 1;
        }

        return Integer.parseInt(span);
    }

    /**
     * To get the abbr attribute of the html element (td, th)
     *
     * @param component the html element
     * @return the abbr attribute of the html element
     */
    String abbr(Component component) {
        return evaluator.attribute(component.id(), Attribute.abbr);
    }

    /**
     * To get the rowspan attribute of the html element (td, th)
     *
     * @param component the html element
     * @return the rowspan attribute of the html element, default is 1
     */
    Integer rowspan(Component component) {
        String rowspan = evaluator.attribute(component.id(), Attribute.rowspan);
        if (rowspan.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(rowspan);
    }

    /**
     * To get the colspan attribute of the html element (td, th)
     *
     * @param component the html element
     * @return the colspan attribute of the html element, default is 1
     */
    Integer colspan(Component component) {
        String colspan = evaluator.attribute(component.id(), Attribute.colspan);
        if (colspan.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(colspan);
    }

    /**
     * To get the axis attribute of the html element (td, th)
     *
     * @param component the html element
     * @return the axis attribute of the html element
     */
    String axis(Component component) {
        return evaluator.attribute(component.id(), Attribute.axis);
    }

    /**
     * To get the headers attribute of the html element (td, th)
     *
     * @param component the html element
     * @return the headers attribute of the html element
     */
    String headers(Component component) {
        return evaluator.attribute(component.id(), Attribute.headers);
    }

    /**
     * To get the scope attribute of the html element (td, th)
     *
     * @param component the html element
     * @return the scope attribute of the html element
     */
    Scope scope(Component component) {
        return Scope.valueOf(evaluator.attribute(component.id(), Attribute.scope));
    }

    /**
     * To get the media attribute of the "link" element
     *
     * @param link the "link" element
     * @return the media attribute of the "link" element
     */
    String media(Link link) {
        return evaluator.attribute(link.id(), Attribute.media);
    }

    /**
     * To get the rows attribute of the html element (frameset, textarea)
     *
     * @param component the html element
     * @return the rows attribute of the html element
     */
    Integer rows(Component component) {
        return Integer.parseInt(evaluator.attribute(component.id(), Attribute.rows));
    }

    /**
     * To get the cols attribute of the html element (frameset, textarea)
     *
     * @param component the html element
     * @return the cols attribute of the html element
     */
    Integer cols(Component component) {
        return Integer.parseInt(evaluator.attribute(component.id(), Attribute.cols));
    }

    /**
     * To get the for attribute of the "label" element
     *
     * @param label the "label" element
     * @return the for attribute of the "label" element
     */
    String _for(Label label) {
        return (evaluator.attribute(label.id(), Attribute._for));
    }

    /**
     * To get the src attribute of the html element (ex : input, img, ...)
     *
     * @param component the html element
     * @return the src attribute of the html element
     */
    String src(Component component) {
        return (evaluator.attribute(component.id(), Attribute.src));
    }

    /**
     * To get the frameborder attribute of the html element (frame, iframe)
     *
     * @param component the html element
     * @return the frameborder attribute of the html element, default is 1
     */
    Integer frameborder(Component component) {
        String frameborder = evaluator.attribute(component.id(), Attribute.frameborder);
        if (frameborder.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(frameborder);
    }

    /**
     * To get the marginwidth attribute of the html element (frame, iframe)
     *
     * @param component the html element
     * @return the marginwidth attribute of the html element, default is 1
     */
    Integer marginwidth(Component component) {
        String marginwidth = evaluator.attribute(component.id(), Attribute.marginwidth);
        if (marginwidth.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(marginwidth);
    }

    /**
     * To get the marginheight attribute of the html element (frame, iframe)
     *
     * @param component the html element
     * @return the marginheight attribute of the html element, default is 1
     */
    Integer marginheight(Component component) {
        String marginheight = evaluator.attribute(component.id(), Attribute.marginheight);
        if (marginheight.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(marginheight);
    }

    /**
     * To get the noresize attribute of the "frame" element
     *
     * @param frame the "frame" element
     * @return the noresize attribute of the "frame" element
     */
    Boolean noresize(Frame frame) {
        return evaluator.exist(frame.id(), Attribute.noresize);
    }

    /**
     * To get the scrolling attribute of the html element (frame, iframe)
     *
     * @param component the html element
     * @return the scrolling attribute of the html element, default is auto
     */
    Scrolling scrolling(Component component) {
        String value = evaluator.attribute(component.id(), Attribute.scrolling);
        if (value.isEmpty()) {
            return Scrolling.auto;
        }
        return Scrolling.valueOf(value);
    }

    /**
     * To get the classid attribute of the "object" element
     *
     * @param object the "object" element
     * @return the classid attribute of the "object" element
     */
    String classid(Object object) {
        return evaluator.attribute(object.id(), Attribute.classid);
    }

    /**
     * To get the codebase attribute of the "object" element
     *
     * @param object the "object" element
     * @return the codebase attribute of the o"bject" element
     */
    String codebase(Object object) {
        return evaluator.attribute(object.id(), Attribute.codebase);
    }

    /**
     * To get the data attribute of the "object" element
     *
     * @param object the "object" element
     * @return the data attribute of the "object" element
     */
    String data(Object object) {
        return evaluator.attribute(object.id(), Attribute.data);
    }

    /**
     * To get the codetype attribute of the "object" element
     *
     * @param object the "object" element
     * @return the codetype attribute of the "object" element
     */
    String codetype(Object object) {
        return evaluator.attribute(object.id(), Attribute.codetype);
    }

    /**
     * To get the archive attribute of the "object" element
     *
     * @param object the "object" element
     * @return the archive attribute of the "object" element
     */
    String archive(Object object) {
        return evaluator.attribute(object.id(), Attribute.archive);
    }

    /**
     * To get the standby attribute of the "object" element
     *
     * @param object the "object" element
     * @return the standby attribute of the "object" element
     */
    String standby(Object object) {
        return evaluator.attribute(object.id(), Attribute.standby);
    }

    /**
     * To get the height attribute of the html element (ex : td, img, object, ...)
     *
     * @param component the html element
     * @return the height attribute of the html element
     */
    String height(Component component) {
        return evaluator.attribute(component.id(), Attribute.height);
    }

    /**
     * To get the valuetype attribute of the "param" element
     *
     * @param param the "param" element
     * @return the valuetype attribute of the "param" element, default is "data"
     */
    ValueType valuetype(Param param) {
        if (evaluator.attribute(param.id(), Attribute.valuetype).equals(""))
            return ValueType.data;
        else
            return ValueType.valueOf(evaluator.attribute(param.id(), Attribute.valuetype));
    }

    /**
     * To get the cols attribute of the  "frameset" element
     *
     * @param frameset the "frameset" element
     * @return the cols attribute of the "frameset" element
     */
    String framesetCols(FrameSet frameset) {
        return evaluator.attribute(frameset.id(), Attribute.cols);
    }

    /**
     * To get the rows attribute of the "frameset" element
     *
     * @param frameset the "frameset" element
     * @return the rows attribute of the "frameset" element
     */
    String framesetRows(FrameSet frameset) {
        return evaluator.attribute(frameset.id(), Attribute.rows);
    }
}

