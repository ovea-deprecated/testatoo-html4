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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Link;

/**
 * This class allows the testing of the "link" element properties for html4.
 * Link defines a link to an external resource, most commonly used to link a CSS file to an HTML document.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/links.html#edef-LINK"> "link" specification </a>
 */

public final class Link extends org.testatoo.core.component.Link implements Coreattrs, I18n {
    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;

    /**
     * Class constructor specifying the evaluator to use and the id of the "link" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "link" element
     * @throws ComponentException if the given id does not correspond to a "link" element
     */
    public Link(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);

        if (evaluator.htmlElementType(id) != Link) {
            throw new ComponentException("The component with id=" + id + " is not a " + Link + " but a " + evaluator.htmlElementType(id));
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
     * To get the charset attribute of the "link" element.
     *
     * @return the charset attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-charset">W3C recommendation</a>
     */
    public String charset() {
        return attributeSupport.charset(this);
    }

    /**
     * To get the href attribute of the "link" element.
     *
     * @return the href attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-href">W3C recommendation</a>
     */
    public String href() {
        return attributeSupport.href(this);
    }

    /**
     * To get the hreflang attribute of the "link" element.
     *
     * @return the hreflang attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-hreflang">W3C recommendation</a>
     */
    public String hreflang() {
        return attributeSupport.hreflang(this);
    }

    /**
     * To get the type attribute of the "link" element.
     *
     * @return the type attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-type-A">W3C recommendation</a>
     */
    public String type() {
        return attributeSupport.type(this);
    }

    /**
     * To get the rel attribute of the "link" element.
     *
     * @return the rel attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-rel">W3C recommendation</a>
     */
    public String rel() {
        return attributeSupport.rel(this);
    }

    /**
     * To get the rev attribute of the "link" element.
     *
     * @return the rev attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/struct/links.html#adef-rev">W3C recommendation</a>
     */
    public String rev() {
        return attributeSupport.rev(this);
    }

    /**
     * To get the media attribute of the "link" element.
     *
     * @return the media attribute of the "link" element
     * @see <a href="http://www.w3.org/TR/html401/present/styles.html#adef-media">W3C recommendation</a>
     */
    public String media() {
        return attributeSupport.media(this);
    }

    @Override
    public Boolean isVisible() {
        // A link is always invisible
        return false;
    }

    @Override
    public Boolean isEnabled() {
        // A link is always invisible
        return true;
    }

    /**
     * To get the string describing the "link" element.
     *
     * @return string describing the "link" element
     */
    public String toString() {
        return super.toString();
    }
}
