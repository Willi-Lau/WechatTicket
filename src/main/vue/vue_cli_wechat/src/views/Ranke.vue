<template>
    <div>

        <div v-for="(item,index) in candidate" class="router_buy_all" style="border: 1px solid darkgray" @click="candidateinf(item.cid)">


            <img class="router_buy_all_img" :src=item.imgurl width="100px" ><br>
            <span style="font-size: 20px">排名:{{index+1}}</span> <br>
            选手id:<span>{{item.cid}}</span>
            选手票数:<span>{{item.tickets}}</span>
            选手礼物:<span>{{item.gifts}}</span>


        </div>

        <div style="height: 200px"></div>


        <BottomComponents></BottomComponents>

    </div>

</template>
<script>
    import BottomComponents from '@/components/BottomComponents.vue'
    export default {
        data(){

            return{
                candidate:{}
            }
        },
        components :{
            BottomComponents
        },
        created() {
            // selectcandidateranke
            this.$axios.post('RankeController/selectcandidateranke',
                this.$qs.stringify(
                    {
                    })
            ).then(response=>{
                this.candidate = response.data;
                console.log(response.data)
                for(let i=0;i<this.candidate.length;i++){
                    this.candidate[i].imgurl = require("../assets/Candidate/"+this.candidate[i].imgurl+".jpg");

                }
            }).catch(error=>{
                console.log(error)
            });
        },
        methods:{
            candidateinf(cid){
                this.$router.push({
                    path:'/ticket' ,

                    query:{
                        cid:cid
                    }
                })
            },
        }
    }
</script>