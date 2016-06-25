/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viettd.elasticsearch.analysis;

import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

/**
 *
 * @author viettd
 */
public class NormalizedKeyWordAnalyzerProvider extends AbstractIndexAnalyzerProvider {

    public static final String NAME = "normalized-keyword-analyzer";
    protected NormalizedKeyWordAnalyzer analyzer = new NormalizedKeyWordAnalyzer();

    @Inject
    public NormalizedKeyWordAnalyzerProvider(Index index, Settings indexSettings, String name, Settings settings) {
        super(index, indexSettings, name, settings);
    }

    @Override
    public NormalizedKeyWordAnalyzer get() {
        return this.analyzer;
    }

}
