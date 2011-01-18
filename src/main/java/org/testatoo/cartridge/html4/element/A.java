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
import org.testatoo.core.ComponentException;

import static org.testatoo.cartridge.html4.element.HtmlElementType.A;

/**
 * This class allows the testing of the "a" element properties for html4.
 * A is an anchor (source or destination) in a link.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/links.html#edef-A"> "a" specification </a>
 */
public final class A extends org.testatoo.core.component.Link implements Coreattrs, I18n {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "a" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "a" element
     * @throws ComponentException if the given id does not correspond to a "a" element
     */
    public A(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != A) {
            throw new ComponentException("The component with id=" + id + " is not a " + A + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * @see CoreAttributeSupport
     */
    public String classname() {
        return coreAttributeSupport.classname(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String style() {
        return coreAttributeSupport.style(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String title() {
        return coreAttributeSupport.title(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public String language() {
        return i18nAttributeSupport.language(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }

    /**
     * To get the type attribute of the "a" element.
     *
     * @return the type attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-type-A">W3C recommendation</a>
     */
    public String type() {
        return attributeSupport.type(this);
    }

    /**
     * To get the name attribute of the "a" element.
     *
     * @return the name attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-name-A">W3C recommendation</a>
     */
    public String name() {
        return attributeSupport.name(this);
    }

    /**
     * To get the charset attribute of the "a" element.
     *
     * @return the charset attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-charset">W3C recommendation</a>
     */
    public String charset() {
        return attributeSupport.charset(this);
    }

    /**
     * To get the href attribute of the "a" element.
     *
     * @return the href attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-href">W3C recommendation</a>
     */
    public String href() {
        return attributeSupport.href(this);
    }

    /**
     * To get the hreflang attribute of the "a" element.
     *
     * @return the hreflang attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-hreflang">W3C recommendation</a>
     */
    public String hreflang() {
        return attributeSupport.hreflang(this);
    }

    /**
     * To get the rel attribute of the "a" element.
     *
     * @return the rel attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-rel">W3C recommendation</a>
     */
    public String rel() {
        return attributeSupport.rel(this);
    }

    /**
     * To get the rev attribute of the "a" element.
     *
     * @return the rev attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-rev">W3C recommendation</a>
     */
    public String rev() {
        return attributeSupport.rev(this);
    }

    /**
     * To get the accesskey attribute of the "a" element
     *
     * @return the accesskey attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-accesskey">W3C recommendation</a>
     */
    public String accesskey() {
        return attributeSupport.accesskey(this);
    }

    /**
     * To get the shape attribute of the "a" element.
     *
     * @return the shape attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-shape">W3C recommendation</a>
     */
    public Shape shape() {
        return attributeSupport.shape(this);
    }

    /**
     * To get the coords attribute of the "a" element.
     *
     * @return the coords attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/struct/objects.html#adef-coords">W3C recommendation</a>
     */
    public String coords() {
        return attributeSupport.coords(this);
    }

    /**
     * To get the tabindex attribute of the "a" element.
     *
     * @return the tabindex attribute of the "a" element
     * @see <a href="http://www.w3.org/TR/html401/interact/forms.html#adef-tabindex">W3C recommendation</a>
     */
    public int tabindex() {
        return attributeSupport.tabindex(this);
    }


}
