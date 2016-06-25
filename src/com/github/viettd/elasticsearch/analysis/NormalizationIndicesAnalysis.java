/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.analysis;

import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.AnalyzerScope;
import org.elasticsearch.index.analysis.PreBuiltAnalyzerProviderFactory;
import org.elasticsearch.indices.analysis.IndicesAnalysisService;

/**
 *
 * @author viettd
 */
public class NormalizationIndicesAnalysis extends AbstractComponent {

    @Inject
    public NormalizationIndicesAnalysis(Settings settings, IndicesAnalysisService indicesAnalysisService) {
        super(settings);

        indicesAnalysisService.analyzerProviderFactories().put(NormalizationAnalyzerProvider.NAME,
                new PreBuiltAnalyzerProviderFactory(NormalizationAnalyzerProvider.NAME,
                        AnalyzerScope.INDICES, new NormalizationAnalyzer()
                )
        );
    }

}
