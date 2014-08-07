/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codehaus.griffon.runtime.swing.swingx

import griffon.core.GriffonApplication
import griffon.core.test.GriffonUnitRule
import griffon.util.BuilderCustomizer
import griffon.util.CompositeBuilder
import groovy.swing.factory.TableFactory
import org.jdesktop.swingx.JXTable
import org.junit.Rule
import spock.lang.Specification

import javax.annotation.Nonnull
import javax.inject.Inject

import static griffon.util.AnnotationUtils.sortByDependencies

/**
 * @author Andres Almiray
 */
class SwingxSwingGroovyModuleSpec extends Specification {
    static {
        System.setProperty('org.slf4j.simpleLogger.defaultLogLevel', 'trace')
    }

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    @Inject
    private GriffonApplication application

    def 'Builder customizer is configured correctly'() {
        when:
        FactoryBuilderSupport builder = createBuilder(application)

        then:
        builder.factories.containsKey('jxtable')
        builder.factories.jxtable.class == TableFactory
        builder.factories.jxtable.beanClass == JXTable

        where:
        _ | name                        | type

        _ | jxmultiSplitLayout          | org.jdesktop.swingx.MultiSplitLayout
        _ | jxstackLayout               | org.jdesktop.swingx.StackLayout
        _ | jxverticalLayout            | org.jdesktop.swingx.VerticalLayout
        _ | jxhorizontalLayout          | org.jdesktop.swingx.HorizontalLayout
        _ | jxframe                     | org.jdesktop.swingx.JXFrame
        _ | jxpanel                     | org.jdesktop.swingx.JXPanel
        _ | jxtitledPanel               | org.jdesktop.swingx.JXTitledPanel
        _ | jxtitledSeparator           | org.jdesktop.swingx.JXTitledSeparator
        _ | jxlabel                     | org.jdesktop.swingx.JXLabel
        _ | jxbutton                    | org.jdesktop.swingx.JXButton
        _ | jxbusyLabel                 | org.jdesktop.swingx.JXBusyLabel
        _ | jxfindPanel                 | org.jdesktop.swingx.JXFindPanel
        _ | jxfindBar                   | org.jdesktop.swingx.JXFindBar
        _ | jxsearchPanel               | org.jdesktop.swingx.JXSearchPanel
        _ | jxerrorPane                 | org.jdesktop.swingx.JXErrorPane
        _ | jximageView                 | org.jdesktop.swingx.JXImageView
        _ | jximagePanel                | org.jdesktop.swingx.JXImagePanel
        _ | jxdatePicker                | org.jdesktop.swingx.JXDatePicker
        _ | jxdialog                    | org.jdesktop.swingx.JXDialog
        _ | jxlist                      | org.jdesktop.swingx.JXList
        _ | jxloginPanel                | org.jdesktop.swingx.JXLoginPane
        _ | jxmonthView                 | org.jdesktop.swingx.JXMonthView
        _ | jxstatusBar                 | org.jdesktop.swingx.JXStatusBar
        _ | jxcollapsiblePane           | org.jdesktop.swingx.JXCollapsiblePane
        _ | jxeditorPane                | org.jdesktop.swingx.JXEditorPane
        _ | jxcolorSelectionButton      | org.jdesktop.swingx.JXColorSelectionButton
        _ | jxgraph                     | org.jdesktop.swingx.JXGraph
        _ | jxheader                    | org.jdesktop.swingx.JXHeader
        _ | jxhyperlink                 | org.jdesktop.swingx.JXHyperlink
        _ | jxtipOfTheDay               | org.jdesktop.swingx.JXTipOfTheDay
        _ | jxtable                     | org.jdesktop.swingx.JXTable
        _ | jxtree                      | org.jdesktop.swingx.JXTree
        _ | jxtreeTable                 | org.jdesktop.swingx.JXTreeTable
        _ | jxdefaultTipModel           | org.jdesktop.swingx.tips.DefaultTipOfTheDayModel
        _ | jxdefaultTip                | org.jdesktop.swingx.tips.DefaultTip
        _ | jxtaskPaneContainer         | org.jdesktop.swingx.JXTaskPaneContainer
        _ | jxtaskPane                  | org.jdesktop.swingx.JXTaskPane
        _ | jxradioGroup                | org.jdesktop.swingx.JXRadioGroup
        _ | jxeyeDropperColorChooser    | org.jdesktop.swingx.color.EyeDropperColorChooserPanel
        _ | jxgradientPreviewPanel      | org.jdesktop.swingx.color.GradientPreviewPanel
        _ | jxgradientChooser           | org.jdesktop.swingx.JXGradientChooser
        _ | jxrootPane                  | org.jdesktop.swingx.JXRootPane
        _ | jxtableHeader               | org.jdesktop.swingx.JXTableHeader
        _ | jxemptyIcon                 | org.jdesktop.swingx.icon.EmptyIcon
        _ | jxcolumnControlIcon         | org.jdesktop.swingx.icon.ColumnControlIcon
        _ | jxmapComboBoxModel          | org.jdesktop.swingx.combobox.MapComboBoxModel
        _ | jxlistComboBoxModel         | org.jdesktop.swingx.combobox.ListComboBoxModel
        _ | jxdropShadowBorder          | org.jdesktop.swingx.border.DropShadowBorder
        _ | jxiconBorder                | org.jdesktop.swingx.border.IconBorder
        _ | jxleaf                      | org.jdesktop.swingx.MultiSplitLayout.Leaf
        _ | jxdivider                   | org.jdesktop.swingx.MultiSplitLayout.Divider
        _ | jxsplit                     | org.jdesktop.swingx.MultiSplitLayout.Split
        _ | jxmultiSplitPane            | org.jdesktop.swingx.JXMultiSplitPane
        _ | jxcolorTintFilter           | org.jdesktop.swingx.image.ColorTintFilter
        _ | jxfastBlurFilter            | org.jdesktop.swingx.image.FastBlurFilter
        _ | jxgaussianBlurFilter        | org.jdesktop.swingx.image.GaussianBlurFilter
        _ | jxstackBlurFilter           | org.jdesktop.swingx.image.StackBlurFilter
        _ | jxglowPathEffect            | org.jdesktop.swingx.painter.effects.GlowPathEffect
        _ | jxinnerGlowPathEffect       | org.jdesktop.swingx.painter.effects.InnerGlowPathEffect
        _ | jxinnerShadowPathEffect     | org.jdesktop.swingx.painter.effects.InnerShadowPathEffect
        _ | jxneonBorderEffect          | org.jdesktop.swingx.painter.effects.NeonBorderEffect
        _ | jxshadowPathEffect          | org.jdesktop.swingx.painter.effects.ShadowPathEffect
        _ | jximagePainter              | org.jdesktop.swingx.painter.ImagePainter
        _ | jxmattePainter              | org.jdesktop.swingx.painter.MattePainter
        _ | jxshapePainter              | org.jdesktop.swingx.painter.ShapePainter
        _ | jxtextPainter               | org.jdesktop.swingx.painter.TextPainter
        _ | jxalphaPainter              | org.jdesktop.swingx.painter.AlphaPainter
        _ | jxcompoundPainter           | org.jdesktop.swingx.painter.CompoundPainter
        _ | jxrectanglePainter          | org.jdesktop.swingx.painter.RectanglePainter
        _ | jxbusyPainter               | org.jdesktop.swingx.painter.BusyPainter
        _ | jxpinstripePainter          | org.jdesktop.swingx.painter.PinstripePainter
        _ | jxglossPainter              | org.jdesktop.swingx.painter.GlossPainter
        _ | jxcheckerboardPainter       | org.jdesktop.swingx.painter.CheckerboardPainter
        _ | jxcolorHighlighter          | org.jdesktop.swingx.decorator.ColorHighlighter
        _ | jxpainterHighlighter        | org.jdesktop.swingx.decorator.PainterHighlighter
        _ | jxaltStripingHighlighter    | org.jdesktop.swingx.decorator.Highlighter
        _ | jxsimpleStripingHighlighter | org.jdesktop.swingx.decorator.Highlighter


    }

    private static final String BUILDER_CUSTOMIZER = 'BuilderCustomizer'

    @Nonnull
    protected FactoryBuilderSupport createBuilder(@Nonnull GriffonApplication application) {
        Collection<BuilderCustomizer> customizers = resolveBuilderCustomizers(application)
        return new CompositeBuilder(customizers.toArray(new BuilderCustomizer[customizers.size()]))
    }

    @Nonnull
    private Collection<BuilderCustomizer> resolveBuilderCustomizers(@Nonnull GriffonApplication application) {
        Collection<BuilderCustomizer> customizerInstances = application.injector.getInstances(BuilderCustomizer)
        return griffon.util.AnnotationUtils.sortByDependencies(customizerInstances, BUILDER_CUSTOMIZER, 'customizer').values()
    }
}
