/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.analysis;

import org.elasticsearch.index.analysis.AnalysisModule;

/**
 *
 * @author viettd
 */
public class NormalizedKeyWordBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {

    @Override
    public void processAnalyzers(AnalyzersBindings analyzersBindings) {
        analyzersBindings.processAnalyzer(NormalizedKeyWordAnalyzerProvider.NAME,
                NormalizedKeyWordAnalyzerProvider.class);
    }
    
    
}
