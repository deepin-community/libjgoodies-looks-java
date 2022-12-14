/*
 * Copyright (c) 2001-2014 JGoodies Software GmbH. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of JGoodies Software GmbH nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jgoodies.looks;

import java.awt.Font;
import java.awt.Toolkit;

import com.jgoodies.common.base.SystemUtils;


/**
 * Provides static access to popular Windows fonts.
 * The sizes of the font constants are specified in
 * <em>typographic points</em>, approximately 1/72 of an inch.<p>
 *
 * TODO: Consider changing the visibility of the package private methods
 * to public. As an alternative we may provide a FontPolicy that can
 * emulate the font choice on Windows XP/2000 and Windows Vista for
 * different software resolutions (96dpi/120dpi) and desktop font size settings
 * (Normal/Large/Extra Large).
 *
 * @author  Karsten Lentzsch
 * @version $Revision: 1.22 $
 *
 * @see     FontSet
 * @see     FontSets
 * @see     FontPolicy
 * @see     FontPolicies
 *
 * @since 2.0
 */
public final class Fonts {

    /**
     * The name of the default dialog font on western Windows XP.
     */
    public static final String TAHOMA_NAME   = "Tahoma";

    /**
     * The name of the default dialog font on western Windows Vista.
     */
    public static final String SEGOE_UI_NAME = "Segoe UI";


    // Physical Fonts *********************************************************

    /**
     * This is the default font on western XP with 96dpi and normal fonts.
     * Ascent=11, descent=3, height=14, dbuX=6, dbuY=12, 14dluY=21px.
     */
    public static final Font TAHOMA_11PT   = new Font(TAHOMA_NAME, Font.PLAIN, 11);

    /**
     * Ascent=13, descent=3, height=16, dbuX=8, dbuY=13, 14dluY=22.75px.
     */
    public static final Font TAHOMA_13PT   = new Font(TAHOMA_NAME, Font.PLAIN, 13);

    /**
     * Ascent=14, descent=3, height=17, dbuX=8, dbuY=14, 14dluY=24.5px.
     */
    public static final Font TAHOMA_14PT   = new Font(TAHOMA_NAME, Font.PLAIN, 14);

    /**
     * This is Segoe UI 9pt, the default font on western Vista with 96dpi.
     * Ascent=13, descent=4, height=17, dbuX=7, dbuY=13, 13dluY=21.125px.
     */
    public static final Font SEGOE_UI_12PT = new Font(SEGOE_UI_NAME, Font.PLAIN, 12);

    /**
     * Ascent=14, descent=4, height=18, dbuX=8, dbuY=14, 13dluY=22.75px.
     */
    public static final Font SEGOE_UI_13PT = new Font(SEGOE_UI_NAME, Font.PLAIN, 13);

    /**
     * Ascent=16, descent=5, height=21, dbuX=9, dbuY=16, 13dluY=26px.
     */
    public static final Font SEGOE_UI_15PT = new Font(SEGOE_UI_NAME, Font.PLAIN, 15);


    // Default Windows Fonts **************************************************

    /**
     * The default icon font on western Windows XP with 96dpi
     * and the dialog font desktop setting "Normal".
     */
    public static final Font WINDOWS_XP_96DPI_NORMAL = TAHOMA_11PT;

    /**
     * The default GUI font on western Windows XP with 96dpi
     * and the dialog font desktop setting "Normal".
     */
    public static final Font WINDOWS_XP_96DPI_DEFAULT_GUI = TAHOMA_11PT;

    /**
     * The default icon font on western Windows XP with 96dpi
     * and the dialog font desktop setting "Large".
     */
    public static final Font WINDOWS_XP_96DPI_LARGE = TAHOMA_13PT;

    /**
     * The default icon font on western Windows XP with 120dpi
     * and the dialog font desktop setting "Normal".
     */
    public static final Font WINDOWS_XP_120DPI_NORMAL = TAHOMA_14PT;

    /**
     * The default GUI font on western Windows XP with 120dpi
     * and the dialog font desktop setting "Normal".
     */
    public static final Font WINDOWS_XP_120DPI_DEFAULT_GUI = TAHOMA_13PT;

    /**
     * The default icon font on western Windows Vista with 96dpi
     * and the dialog font desktop setting "Normal".
     */
    public static final Font WINDOWS_VISTA_96DPI_NORMAL = SEGOE_UI_12PT;

    /**
     * The default icon font on western Windows Vista with 96dpi
     * and the dialog font desktop setting "Large".
     */
    public static final Font WINDOWS_VISTA_96DPI_LARGE = SEGOE_UI_15PT;

    /**
     * The default icon font on western Windows Vista with 120dpi
     * and the dialog font desktop setting "Normal".
     */
    public static final Font WINDOWS_VISTA_120DPI_NORMAL = SEGOE_UI_15PT;


    // Desktop Property Font Keys *********************************************

    /**
     * The desktop property key used to lookup the DEFAULTGUI font.
     * This font scales with the software resolution only
     * but works in western and non-western Windows environments.
     *
     * @see #getWindowsControlFont()
     */
    static final String WINDOWS_DEFAULT_GUI_FONT_KEY = "win.defaultGUI.font";

    /**
     * The desktop property key used to lookup Windows' icon font.
     * This font scales with the software resolution and
     * the desktop font size setting (Normal/Large/Extra Large).
     * However, in some non-western Windows environments
     * this font cannot display the locale's glyphs.
     * Therefore a fallback is needed for these locales.
     * Such a fallback can be achieved with composite fonts.
     * See the Windows default font policy for more an implementation
     * that aims to obtain composite fonts.
     *
     * @see #getWindowsControlFont()
     */
    static final String WINDOWS_ICON_FONT_KEY = "win.icon.font";


    // Instance Creation ******************************************************

    private Fonts() {
        // Override default constructor; prevents instantation.
    }


    // Font Lookup ************************************************************

    static Font getDefaultGUIFontWesternModernWindowsNormal() {
        return SystemUtils.IS_LOW_RESOLUTION
            ? WINDOWS_XP_96DPI_DEFAULT_GUI
            : WINDOWS_XP_120DPI_DEFAULT_GUI;
    }

    static Font getDefaultIconFontWesternModernWindowsNormal() {
        return SystemUtils.IS_LOW_RESOLUTION
            ? WINDOWS_XP_96DPI_NORMAL
            : WINDOWS_XP_120DPI_NORMAL;
    }

    static Font getDefaultIconFontWesternWindowsVistaNormal() {
        return SystemUtils.IS_LOW_RESOLUTION
            ? WINDOWS_VISTA_96DPI_NORMAL
            : WINDOWS_VISTA_120DPI_NORMAL;
    }


    /**
     * Returns the Windows control font used by the JGoodies Looks version 1.x.
     * It is intended for visual backward compatibility only.
     * The font returned is the default GUI font that scales with the resolution
     * (96dpi, 120dpi, etc) but not with the desktop font size settings
     * (normal, large, extra large).<p>
     *
     * On Windows Vista, the font may be completely wrong.
     *
     * @return the Windows default GUI font that scales with the resolution,
     *     but not the desktop font size setting
     *
     * @throws UnsupportedOperationException on non-Windows platforms
     */
    static Font getLooks1xWindowsControlFont() {
        if (!SystemUtils.IS_OS_WINDOWS) {
            throw new UnsupportedOperationException();
        }

        return getDesktopFont(WINDOWS_DEFAULT_GUI_FONT_KEY);
    }


    /**
     * Looks up and returns the Windows control font. Returns the Windows icon
     * title font unless it is inappropriate for the Windows version.<p>
     *
     * The icon title font scales with the resolution (96dpi, 101dpi, 120dpi, etc)
     * and the desktop font size settings (normal, large, extra large).
     * Older versions may return a poor font.
     *
     * @return the Windows control font
     *
     * @throws UnsupportedOperationException on non-Windows platforms
     */
    public static Font getWindowsControlFont() {
        if (!SystemUtils.IS_OS_WINDOWS) {
            throw new UnsupportedOperationException("The Windows control font can be computed only on the Windows platform.");
        }

        // Return the default GUI font on older Windows versions.
        if (LookUtils.IS_OS_WINDOWS_95
        ||  SystemUtils.IS_OS_WINDOWS_98
        ||  LookUtils.IS_OS_WINDOWS_NT
        ||  SystemUtils.IS_OS_WINDOWS_ME) {
            return getDefaultGUIFont();
        }
        return getIconFont();
    }


    /**
     * Looks up and returns the Windows defaultGUI font.
     * Works around a bug with Java 1.4.2_17, 1.5.0_15, and 1.6.0
     * on Vista, where the win.defaultGUI.font desktop property
     * returns {@code null}. In this case a logical "Dialog" font
     * is used as fallback.
     *
     * @return the Windows defaultGUI font, or a dialog font as fallback.
     */
    private static Font getDefaultGUIFont() {
        Font font = getDesktopFont(WINDOWS_DEFAULT_GUI_FONT_KEY);
        return font != null
                ? font
                : getFallbackFont();
    }
    
    
    private static Font getIconFont() {
        Font font = getDesktopFont(WINDOWS_ICON_FONT_KEY);
        return font != null
                ? font
                : getFallbackFont();
    }
    
    
    private static Font getFallbackFont() {
        return new Font("Dialog", Font.PLAIN, 12);
    }


    /**
     * Looks up and returns a font using the default toolkit's
     * desktop properties.
     *
     * @param fontName    the name of the font to return
     * @return the font
     */
    private static Font getDesktopFont(String fontName) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        return (Font) toolkit.getDesktopProperty(fontName);
    }


}
