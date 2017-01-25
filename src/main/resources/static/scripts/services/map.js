function PageService($scope, $http, $sce) {
    this.$scope = $scope;
    this.$http = $http;
    this.$sce = $sce;
};
PageService.prototype.init = function () {
    activateJQuery();
    //$('#world-map-gdp').vectorMap({map: 'world_mill'});
    $('#world-map-gdp').vectorMap({
        map: 'world_en',
        //map: 'world_mill',

        backgroundColor: null,
        color: '#ffffff',
        hoverOpacity: 0.7,
        selectedColor: '#849',
        enableZoom: true,
        showTooltip: true,
        values: sample_data,
        scaleColors: ['#E6F2F0', '#149B7E'],
        normalizeFunction: 'polynomial'
    });
    this.rerenderElements();
};
PageService.prototype.rerenderElements = function () {

};

