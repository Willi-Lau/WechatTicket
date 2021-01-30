<template>
    <div class="enter">

        <el-form ref="form" :model="form" label-width="80px" enctype="multipart/form-data" class=form>

            <el-upload
                    class="upload-demo"
                    ref="upload"
                    action="http://localhost:8080/EnterController/upload"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="fileList"
                    :auto-upload="false"
                    :limit="5"
                    name="uploFiles"
                    multiple
                    :data="form">
                <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
            <br>

            <el-form-item label="本人姓名">
                <el-input v-model="form.cname"></el-input>
            </el-form-item>
            <el-form-item label="参赛宣言">
                <el-input v-model="form.cdeclaration"></el-input>
            </el-form-item>
            <el-form-item label="手机">
                <el-input v-model="form.mobile"></el-input>
            </el-form-item>

            <el-form-item label="性别">
                <el-radio-group v-model="form.sex">
                    <el-radio label="男"></el-radio>
                    <el-radio label="女"></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="收货地址">
                <el-input type="textarea" v-model="form.address"></el-input>
            </el-form-item>


            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即创建</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>

        <BottomComponents></BottomComponents>


    </div>

</template>

<script>
    import BottomComponents from '@/components/BottomComponents.vue'
    export default {
        data(){

            return{
                fileList:[],
                fileData:'',

                form: {
                    cname: '',
                    cdeclaration: '',
                    mobile: '',
                    sex: '',
                    address: ''


                }
            }
        },
        components :{
            BottomComponents
        },
        methods:{
            uploadFile(file) {
                this.fileData.append('files', file.file);  // append增加数据
            },
            onSubmit() {
                this.$refs.upload.submit();
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            }
        }
    }
</script>

<style>
    .enter .form{
        position: relative;
        top: 60px;
    }
</style>