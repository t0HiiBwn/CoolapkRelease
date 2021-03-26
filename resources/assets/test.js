var http = require('http');


var promise = new Promise(function(resolve, reject) {
    http.get('http://www.baidu.com', (res) => {
        const { statusCode } = res;
        const contentType = res.headers['content-type'];

        let error;
        if (statusCode !== 200) {
            error = new Error('请求失败。\n' +
                `状态码: ${statusCode}`);
        }

        // else if (!/^application\/json/.test(contentType)) {
        //     error = new Error('无效的 content-type.\n' +
        //         `期望 application/json 但获取的是 ${contentType}`);
        // }

        if (error) {
            // console.error(error.message);
            reject(error);
            // 消耗响应数据以释放内存
            res.resume();
            return;
        }

        res.setEncoding('utf8');
        let rawData = '';
        res.on('data', (chunk) => { rawData += chunk; });
        res.on('end', () => {
            try {
                const parsedData = rawData; //JSON.parse(rawData);
                // console.log(parsedData);
                resolve(parsedData);
            } catch (e) {
                // console.error(e.message);
                reject(e);
            }
        });
    }).on('error', (e) => {
        // console.error(`错误: ${e.message}`);
        reject(e);
    });
});


function test() {
    promise.then(function (response) {
        console.log(response);
    }).catch(err => {
        console.log(err);
    })
}

